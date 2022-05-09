package models;

public class Reading
{
    public int code;
    public double temp;
    public double windSpeed;

    public Reading(int code, double temp, double windSpeed){
        this.code = code;
        this.temp = temp;
        this.windSpeed = windSpeed;
    }
}
