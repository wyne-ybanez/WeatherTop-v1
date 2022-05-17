package controllers;

import java.util.List;

import models.*;
import play.mvc.Controller;

public class Admin extends Controller
{
    public static void index()
    {
        List<Reading> readings = Reading.findAll();
        List<Station> stations = Station.findAll();
        List<Member> members = Member.findAll();
        render("admin.html", readings, stations, members);
    }
}
