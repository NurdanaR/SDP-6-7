package com.weather.weather;

public class RealTimeUpdate implements UpdateStrategy {
    public void updateWeather(WeatherStation station) {
        station.setWeatherData("Cloudy", 15);
    }
}
