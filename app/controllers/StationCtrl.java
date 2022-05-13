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
     */
    public static void index(long id)
    {
        Station station = Station.findById(id);

        // Get the latest reading
        Reading lastReading = station.readings.get( station.readings.size() - 1 );

        // Set latest weather to the converted value of the latest reading
        station.latestWeather = Conversions.convertCodeToWeather(lastReading.code);

        // Set latest weather temperature to the converted Fahrenheit value
        station.temperature = Conversions.convertToFahrenheit(lastReading.temperature);
        double stationFahrenheitValue = station.temperature;

        // Set latest weather wind speed to the converted Beaufort value
        station.wind = Conversions.convertToBeaufort(lastReading.windSpeed);
        int stationBeaufortValue = station.wind;

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
     *  Add Station to database
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
