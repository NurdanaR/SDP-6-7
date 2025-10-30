package com.weather.observer;

public class WebAppDisplay implements WeatherObserver {
    public void update(String condition, int temperature) {
        System.out.println("💻 Web app: " + condition + ", " + temperature + "°C");
    }
}
