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
     *
     *  1. Weather Code conversion value displays in the view for each station.
     *  2. Temperature Celcius to Fahrenheit conversion.
     *  3. Wind Speed to Beaufort conversion.
     *  4. Pressure is as declared by latest reading.
     *  5. Wind compass direction.
     *  6. Wind chill calculation.
     *  7. Max & Min values (Temp, Wind, Pressure).
     */
    public static void index(long id)
    {
        Station station = Station.findById(id);

        // Get the latest reading
        Reading latestReading = station.readings.get( station.readings.size() - 1 );

        // Conversions
        station.latestWeather = Conversions.convertCodeToWeather(latestReading.code);
        station.temperature = Conversions.convertToFahrenheit(latestReading.temperature);
        station.wind = Conversions.convertToBeaufort(latestReading.windSpeed);
        station.pressure = latestReading.pressure;
        station.windCompass = Conversions.convertToCompassDirection(latestReading.windDirection);
        station.windChill = Conversions.windChillCalculator(latestReading.windSpeed, latestReading.temperature);

        // Variables
        double stationFahrenheitValue = station.temperature;
        int stationBeaufortValue = station.wind;

        // Analytics: Max & Min Values (Temperature, Wind, Pressure)
        Reading maxTempReading = StationAnalytics.getMaxTemperature(station.readings);
        Reading minTempReading = StationAnalytics.getMinTemperature(station.readings);
        Reading maxWindReading = StationAnalytics.getMaxWindSpeed(station.readings);
        Reading minWindReading = StationAnalytics.getMinWindSpeed(station.readings);
        Reading maxPressureReading = StationAnalytics.getMaxPressure(station.readings);
        Reading minPressureReading = StationAnalytics.getMinPressure(station.readings);

        Logger.info("Weather Station Id = " + id
                + "\n\n Min temp value: " + minTempReading.temperature
                + "\n Max temp value: " + maxTempReading.temperature
                + "\n\n Min windSpeed value: " + minWindReading.windSpeed
                + "\n Max windSpeed value: " + maxWindReading.windSpeed
                + "\n\n Min pressure value: " + minPressureReading.pressure
                + "\n Max pressure value: " + maxPressureReading.pressure
        );
        render("station.html", station, stationFahrenheitValue, stationBeaufortValue,
                    minTempReading, maxTempReading, minWindReading, maxWindReading,
                    minPressureReading, maxPressureReading);
    }

    /**
    *  Delete reading from database
    */
    public static void deleteReading(long id, long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        station.readings.remove(reading);
        Logger.info("Removing reading code: " + reading.code);
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
        redirect("/stations/" + id);
    }
}
