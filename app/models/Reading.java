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
    public int pressure;

    public Reading(int code, double temperature, double windSpeed, int pressure){
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    /**
     * Limits the Reading code number in range of 100 to 800.
     * Sets weather according to code provided.
     *
     * @return integer value for the 'code'
     */
    private void weatherCode(){
        int code = 0;
        String weather;

        while( code != 0)
        {
            switch (code)
            {
                case 100:
                    weather = "Clear";
                    break;
                case 200:
                    weather = "Partial clouds";
                    break;
                case 300:
                    weather = "Cloudy";
                    break;
                case 400:
                    weather = "Light Showers";
                    break;
                case 500:
                    weather = "Heavy Showers";
                    break;
                case 600:
                    weather = "Rain";
                    break;
                case 700:
                    weather = "Snow";
                    break;
                case 800:
                    weather = "Thunder";
                    break;
                default:
                    System.out.println("Invalid code input.");
                    break;
            }
        }
    }


}
