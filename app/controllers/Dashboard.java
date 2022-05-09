package controllers;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");

    Reading r1 = new Reading(800, 0.5,3.5);
    Reading r2 = new Reading(600, 6.0,2.0);

    Station station = new Station("Tramore");
    station.readings.add (r1);
    station.readings.add (r2);

    render ("dashboard.html", station);
  }
}
