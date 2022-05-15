package controllers;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;

import utils.Conversions;

public class StationCtrl extends Controller
{
    /**
     *  Find a station by ID and obtain the latest Reading.
     *
     *  1. Weather Code conversion value displays in the view for each station.
     *  2. Temperature Celcius to Fahrenheit conversion.
     *  3. Wind Speed to Beaufort conversion.
     *  4. Pressure is as declared by latest reading.
     *  5. Wind compass direction.
     *  6. Wind chill calculation.
     */
    public static void index(long id)
    {
        Station station = Station.findById(id);

        // Get the latest reading
        Reading latestReading = station.readings.get( station.readings.size() - 1 );

        //1. Set latest weather to the converted value of the latest reading
        station.latestWeather = Conversions.convertCodeToWeather(latestReading.code);

        //2. Set latest weather temperature to the converted Fahrenheit value
        station.temperature = Conversions.convertToFahrenheit(latestReading.temperature);
        double stationFahrenheitValue = station.temperature;

        //3. Set latest weather wind speed to the converted Beaufort value
        station.wind = Conversions.convertToBeaufort(latestReading.windSpeed);
        int stationBeaufortValue = station.wind;

        //4. Set latest pressure reading
        station.pressure = latestReading.pressure;

        //5. Set wind compass conversion value
        station.windCompass = Conversions.convertToCompassDirection(latestReading.windDirection);

        //6. Set wind chill value
        station.windChill = Conversions.windChillCalculator(latestReading.windSpeed, latestReading.temperature);

        Logger.info("Weather Station Id = " + id);
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
