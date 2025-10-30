package com.weather.weather;

public class ManualInputUpdate implements UpdateStrategy {
    private String condition;
    private int temperature;

    public ManualInputUpdate(String condition, int temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public void updateWeather(WeatherStation station) {
        station.setWeatherData(condition, temperature);
    }
}
