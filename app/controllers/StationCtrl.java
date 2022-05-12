package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller
{
    //  Find Station by ID
    public static void index(long id)
    {
        Station station = Station.findById(id);
        Logger.info("Weather Station Id = " + id);
        render("station.html", station);
    }

    // Delete a station
    public static void deleteReading(long id, long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);

        Logger.info("Removing reading code: " + reading.code);

        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }
}
