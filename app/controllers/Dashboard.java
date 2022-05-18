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
   *
   * First ensuring that the user is logged in.
   * Then create a new station, adding this to the member's station list.
   *
   * @param stationName
   * @param latitude
   * @param longitude
   */
  public static void addStation(String stationName, double latitude, double longitude)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(stationName, latitude, longitude);
    member.stations.add(station);
    member.save();
    Logger.info("Adding Station: " + stationName
                + "\n Latitude: " + latitude
                + "\n Longitude: " + longitude);
    redirect("/dashboard");
  }

  /**
   * Delete the station from the database.
   *
   * Obtain both the member and the station.
   * Remove the station from the member's station list and delete it.
   *
   * @param id
   * @param stationid
   */
  public static void deleteStation (long id, Long stationid)
  {
    Member member = Member.findById(id);
    Station station = Station.findById(stationid);
    member.stations.remove(station);
    member.save();
    station.delete();
    Logger.info ("Removing: " + station.stationName);
    redirect ("/dashboard");
  }
}
