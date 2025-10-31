package com.weather;

import com.weather.weather.*;
import com.weather.observer.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = WeatherStation.getInstance();

        WeatherObserver phone = new PhoneDisplay();
        WeatherObserver web = new WebAppDisplay();
        WeatherObserver logger = new LoggerObserver();

        station.addObserver(phone);
        station.addObserver(web);
        station.addObserver(logger);

        Scanner sc = new Scanner(System.in);
        System.out.println("Select mode:");
        System.out.println("1 - Real-time update");
        System.out.println("2 - Manual input");
        System.out.println("3 - Scheduled update");
        System.out.println("4 - Weather by date (7-day forecast)");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                station.setStrategy(new RealTimeUpdate());
                break;
            case 2:
                station.setStrategy(new ManualInputUpdate("Sunny", 9));
                break;
            case 3:
                station.setStrategy(new ScheduledUpdate());
                break;
            case 4:
                station.setStrategy(new DateWeatherUpdate());
                break;
            default:
                System.out.println("Invalid choice. Using RealTimeUpdate by default.");
                station.setStrategy(new RealTimeUpdate());
        }

        station.updateWeather();
    }
}
