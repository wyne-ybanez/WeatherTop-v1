package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");

    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  /**
   * Add Station to database
   */
  public static void addStation(String stationName)
  {
    Station station = new Station(stationName);
    station.save();
    Logger.info("Adding Station" + stationName);
    redirect("/dashboard");
  }

  /**
   * Delete Station from database
   */
  public static void deleteStation (long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Removing" + station.stationName);
    station.delete();
    redirect ("/dashboard");
  }
}
