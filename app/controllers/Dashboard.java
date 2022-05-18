package controllers;

import java.util.ArrayList;
import java.util.List;

import models.*;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations, member);
  }

  /**
   * Add Station to database
   */
  public static void addStation(String stationName, double latitude, double longitude)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(stationName, latitude, longitude);
    // station.save();
    member.stations.add(station);
    member.save();
    Logger.info("Adding Station: " + stationName
                + "\n Latitude: " + latitude
                + "\n Longitude: " + longitude);
    redirect("/dashboard");
  }

  /**
   * Delete Station from database
   */
  public static void deleteStation (long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Removing: " + station.stationName);
    station.delete();
    redirect ("/dashboard");
  }
}
