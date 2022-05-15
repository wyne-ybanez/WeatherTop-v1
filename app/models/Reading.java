package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.Logger;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;

    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure){
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }
}
