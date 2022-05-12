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
     *
     * @return integer value for the 'code'
     */
    public static int codeRangeLimit(int code)
    {
        // if code is less than 100
        // automatically place code as '100'
        if( (code < 100) && (code > 800) ){
            Logger.error("Code input is out of bounds, defaults value used: 100");
            code = 100;
            return code;
        }
        return code;
    }
}
