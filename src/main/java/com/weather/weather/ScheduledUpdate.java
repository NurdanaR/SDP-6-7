package com.weather.weather;

public class ScheduledUpdate implements UpdateStrategy {
    public void updateWeather(WeatherStation station) {
        station.setWeatherData("Rainy", 3);
    }
}
