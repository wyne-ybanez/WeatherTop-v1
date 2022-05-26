package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String stationName;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public String latestWeather;
    public double temperature;
    public double fahrenheitTemp;
    public int wind;
    public double windChill;
    public String windCompass;
    public int pressure;
    public double latitude;
    public double longitude;

    // Min Reading variables
    public double minTemperature;
    public double minWindSpeed;
    public int minPressure;

    // Max Reading variables
    public double maxTemperature;
    public double maxWindSpeed;
    public int maxPressure;

    // Trend
    public Boolean tempTrend;
    public Boolean windTrend;
    public Boolean pressureTrend;

    /**
     * Constructor
     * @param stationName
     * @param latitude
     * @param longitude
     */
    public Station(String stationName, double latitude, double longitude)
    {
        this.stationName = stationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStationName(){
        return stationName;
    }
}
