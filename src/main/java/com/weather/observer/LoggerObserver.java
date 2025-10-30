package com.weather.observer;

public class LoggerObserver implements WeatherObserver {
    public void update(String condition, int temperature) {
        System.out.println("[Logger] Weather changed: " + condition + " (" + temperature + "°C)");
    }
}
