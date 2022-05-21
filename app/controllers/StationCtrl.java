package controllers;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;

import static utils.Conversions.processConversions;
import static utils.StationAnalytics.processAnalytics;
import static utils.StationAnalytics.processTrendAnalytics;

public class StationCtrl extends Controller
{
    /**
     *  Find a station by ID and obtain the latest Readings.
     *  Readings contain the following:
     *
     *  1. Weather Code conversion value displays in the view for each station.
     *  2. Temperature Celcius and Fahrenheit conversion value.
     *  3. Wind Speed to Beaufort conversion value.
     *  4. Pressure as declared by latest reading.
     *  5. Wind compass direction.
     *  6. Wind chill.
     *  7. Max & Min values (Temp, Wind, Pressure).
     *  8. Trends for rising or falling (Temp, Wind, Pressure)
     *
     * @param id
     * @return The index will pass variables to/and render the view.
     */
    public static void index(long id) {
        Station station = Station.findById(id);
        processConversions(station);
        processAnalytics(station);
        processTrendAnalytics(station);

        Logger.info("Weather Station Id = " + id
                + "\n\n Max temp value: " + station.maxTemperature
                + "\n Min temp value: " + station.minTemperature
                + "\n\n Max windSpeed value: " + station.maxWindSpeed
                + "\n Min windSpeed value: " + station.minWindSpeed
                + "\n\n Max pressure value: " + station.maxPressure
                + "\n Min pressure value: " + station.minPressure
        );
        render("station.html", station);
    }

    /**
    *  Delete reading from database
    */
    public static void deleteReading(long id, long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        station.readings.remove(reading);
        Logger.info("Removing reading: " + readingid);
        station.save();
        reading.delete();
        redirect("/stations/" + id);
    }

    /**
     *  Add Reading to database
     */
    public static void addReading(long id, int code, double temperature, double windSpeed, double windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        Logger.info("Adding new reading " + reading.id + " to station: " + station.stationName);
        redirect("/stations/" + id);
    }
}
