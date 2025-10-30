package com.weather.weather;

import com.weather.observer.WeatherObserver;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private static WeatherStation instance;
    private List<WeatherObserver> observers = new ArrayList<>();
    private UpdateStrategy strategy;
    private String condition;
    private int temperature;

    private WeatherStation() {}

    public static WeatherStation getInstance() {
        if (instance == null) {
            instance = new WeatherStation();
        }
        return instance;
    }

    public void addObserver(WeatherObserver o) {
        observers.add(o);
    }

    public void setStrategy(UpdateStrategy s) {
        this.strategy = s;
    }

    public void setWeatherData(String condition, int temp) {
        this.condition = condition;
        this.temperature = temp;
        notifyObservers();
    }

    public void updateWeather() {
        if (strategy != null) {
            strategy.updateWeather(this);
        }
    }

    private void notifyObservers() {
        for (WeatherObserver o : observers) {
            o.update(condition, temperature);
        }
    }
}
