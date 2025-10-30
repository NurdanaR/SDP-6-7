package com.weather.observer;

public interface WeatherObserver {
    void update(String condition, int temperature);
}
