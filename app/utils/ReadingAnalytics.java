package utils;

import models.Reading;

import java.util.List;
import play.Logger;

public class ReadingAnalytics {
    /**
     *  Convert temp, wind and pressure.
     *  Undergoes conversions and returns converted values.
     *  Import to StationCtrl.
     */
    public static String convertCodeToWeather(int weatherCode) {
        String weather = "";
        // Convert Code to weather
        while (weatherCode != 0) {
            switch (weatherCode) {
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
                    Logger.error("Invalid code input");
                    break;
            }
            return weather;
        }
        return weather;
    }
}
