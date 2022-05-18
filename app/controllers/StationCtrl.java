package controllers;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;

import utils.Conversions;
import utils.StationAnalytics;

public class StationCtrl extends Controller
{
    /**
     *  Find a station by ID and obtain the latest Readings.
     *  Index contains the following:
     *
     *  1. Weather Code conversion value displays in the view for each station.
     *  2. Temperature Celcius to Fahrenheit conversion value.
     *  3. Wind Speed to Beaufort conversion value.
     *  4. Pressure as declared by latest reading.
     *  5. Wind compass direction.
     *  6. Wind chill.
     *  7. Max & Min values (Temp, Wind, Pressure).
     *
     * @param id
     * @return The index will pass variables to/and render the view.
     */
    public static void index(long id) {
        double stationFahrenheitValue = 0.0;
        int stationBeaufortValue = 0;
        Reading latestReading;

        Station station = Station.findById(id);

        if (station.readings.size() > 0) {
            // Get the latest reading
            latestReading = station.readings.get(station.readings.size() - 1);

            // Station Conversions
            station.latestWeather = Conversions.convertCodeToWeather(latestReading.code);
            station.temperature = latestReading.temperature;
            station.wind = Conversions.convertToBeaufort(latestReading.windSpeed);
            station.pressure = latestReading.pressure;
            station.windCompass = Conversions.convertToCompassDirection(latestReading.windDirection);
            station.windChill = Conversions.windChillCalculator(latestReading.windSpeed, latestReading.temperature);

            // Variables
            stationFahrenheitValue = Conversions.convertToFahrenheit(latestReading.temperature);
            stationBeaufortValue = station.wind;

            // Analytics: Max & Min Values (Temperature, Wind, Pressure)
            station.maxTemperature = StationAnalytics.getMaxTemperature(station.readings).temperature;
            station.minTemperature = StationAnalytics.getMinTemperature(station.readings).temperature;
            station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings).windSpeed;
            station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings).windSpeed;
            station.maxPressure = StationAnalytics.getMaxPressure(station.readings).pressure;
            station.minPressure = StationAnalytics.getMinPressure(station.readings).pressure;
        }

        Logger.info("Weather Station Id = " + id
                + "\n\n Max temp value: " + station.maxTemperature
                + "\n Min temp value: " + station.minTemperature
                + "\n\n Max windSpeed value: " + station.maxWindSpeed
                + "\n Min windSpeed value: " + station.minWindSpeed
                + "\n\n Max pressure value: " + station.maxPressure
                + "\n Min pressure value: " + station.minPressure
        );
        render("station.html", station, stationFahrenheitValue, stationBeaufortValue);
    }

    /**
    *  Delete reading from database
    */
    public static void deleteReading(long id, long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        station.readings.remove(reading);
        Logger.info("Removing reading: " + reading.id);
        station.save();
        reading.delete();
        render("station.html", station);
    }

    /**
     *  Add Reading to database
     */
    public static void addReading(long id, int code, double temperature, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        Logger.info("Adding new reading " + reading.id + " to station: " + station.stationName);
        redirect("/stations/" + id);
    }
}
