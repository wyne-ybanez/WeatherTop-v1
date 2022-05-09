package models;

import java.util.ArrayList;
import java.util.List;

public class Station {
    public String stationName;
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String stationName)
    {
        this.stationName = stationName;
    }
}
