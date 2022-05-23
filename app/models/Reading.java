package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;
    public Date date;

    /**
     * Constructor
     *
     * @param code
     * @param temperature
     * @param windSpeed
     * @param windDirection
     * @param pressure
     */
    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure){
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.date = new Date();
    }
}
