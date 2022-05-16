package controllers;

import java.util.List;

import models.Reading;
import models.Station;
import play.mvc.Controller;

import utils.Conversions;

public class Admin extends Controller
{
    public static void index()
    {
        List<Reading> readings = Reading.findAll();
        List<Station> stations = Station.findAll();
        render("admin.html", readings, stations);
    }
}
