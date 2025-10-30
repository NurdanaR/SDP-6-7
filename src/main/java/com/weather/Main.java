package com.weather;

import com.weather.weather.*;
import com.weather.observer.*;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = WeatherStation.getInstance();

        WeatherObserver phone = new PhoneDisplay();
        WeatherObserver web = new WebAppDisplay();
        WeatherObserver logger = new LoggerObserver();


        station.addObserver(phone);
        station.addObserver(web);
        station.addObserver(logger);

        station.setStrategy(new RealTimeUpdate());
        station.updateWeather();


        station.setStrategy(new ManualInputUpdate("Rainy", 17));
        station.updateWeather();

        station.setStrategy(new ScheduledUpdate());
        station.updateWeather();
    }
}
