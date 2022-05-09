package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

public class Station {
    public String stationName;
    public String weather;
    public double temperature;
    public double wind;
    public int pressure;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String stationName, String weather, double temperature, double wind, int pressure)
    {
        this.stationName = stationName;
        this.weather = weather;
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
    }
}
