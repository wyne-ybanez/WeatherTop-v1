package utils;

import play.Logger;

/**
 *  Convert temp, wind and pressure.
 *  Undergoes conversions and returns converted values.
 *  Import to StationCtrl.
 */
public class Conversions {

    /**
     *  Converts reading code to a specified weather value.
     *
     *  @return weather value as a String
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

    /**
     *  Converts Celcius to Farenheit
     *
     *  @return double value for Farenheit
     */
    public static double convertToFahrenheit(double tempInCelcius)
    {
        // Formula for converting celcius to fahrenheit = ( X * 1.8 ) + 32
        double fahrenheitValue = (tempInCelcius * 1.8) + 32;
        return fahrenheitValue;
    }

    /**
     *  kM/hr to Beaufort Conversion
     *
     *  @return int for Beaufort value
     */
    public static int convertToBeaufort(double windSpeed)
    {
        int BeaufortValue = 0;
        String BeaufortLabel = "";

        if (windSpeed == 1.0) {
            BeaufortValue = 0;
            BeaufortLabel = "Calm";
        }
        else if ((windSpeed > 1.0) && (windSpeed <= 5.0)) {
            BeaufortValue = 1;
            BeaufortLabel = "Light Air";
        }
        else if ((windSpeed >= 6.0) && (windSpeed <= 11.0)) {
            BeaufortValue = 2;
            BeaufortLabel = "Light Breeze";
        }
        else if ((windSpeed >= 12.0) && (windSpeed <= 19.0)) {
            BeaufortValue = 3;
            BeaufortLabel = "Gentle Breeze";
        }
        else if ((windSpeed >= 20.0) && (windSpeed <= 28.0)) {
            BeaufortValue = 4;
            BeaufortLabel = "Moderate Breeze";
        }
        else if ((windSpeed >= 29.0) && (windSpeed <= 38.0)) {
            BeaufortValue = 5;
            BeaufortLabel = "Fresh Breeze";
        }
        else if ((windSpeed >= 39.0) && (windSpeed <= 49.0)) {
            BeaufortValue = 6;
            BeaufortLabel = "Strong Breeze";
        }
        else if ((windSpeed >= 50.0) && (windSpeed <= 61.0)) {
            BeaufortValue = 7;
            BeaufortLabel = "Near Gale";
        }
        else if ((windSpeed >= 62.0) && (windSpeed <= 74.0)) {
            BeaufortValue = 8;
            BeaufortLabel = "Gale";
        }
        else if ((windSpeed >= 75.0) && (windSpeed <= 88.0)) {
            BeaufortValue = 9;
            BeaufortLabel = "Severe Gale";
        }
        else if ((windSpeed >= 89.0) && (windSpeed <= 102.0)) {
            BeaufortValue = 10;
            BeaufortLabel = "Strong Storm";
        }
        else if ((windSpeed >= 103) && (windSpeed <= 117)) {
            BeaufortValue = 11;
            BeaufortLabel = "Violent Storm";
        }
        else {
            BeaufortValue = 0;
            BeaufortLabel = "";
            System.out.println("Invalid code input.");
            Logger.error("Invalid code input");
        }
    return BeaufortValue;
    }
}
