package com.weather.observer;

public class PhoneDisplay implements WeatherObserver {
    public void update(String condition, int temperature) {
        System.out.println("📱 Phone display: " + condition + ", " + temperature + "°C");
    }
}
