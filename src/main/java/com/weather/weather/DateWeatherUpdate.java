package com.weather.weather;

import java.util.*;
import java.time.LocalDate;

public class DateWeatherUpdate implements UpdateStrategy {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public void updateWeather(WeatherStation station) {
        Map<String, String> conditionMap = new LinkedHashMap<>();
        Map<String, Integer> maxMap = new LinkedHashMap<>();
        Map<String, Integer> minMap = new LinkedHashMap<>();

        conditionMap.put("31.10", "Cloudy");
        conditionMap.put("01.11", "Colder");
        conditionMap.put("02.11", "Cloudy");
        conditionMap.put("03.11", "Rain and drizzle");
        conditionMap.put("04.11", "Snow at times + gusty wind");
        conditionMap.put("05.11", "Low clouds");
        conditionMap.put("06.11", "Slightly warmer");

        maxMap.put("31.10", 15);
        maxMap.put("01.11", 6);
        maxMap.put("02.11", 6);
        maxMap.put("03.11", 3);
        maxMap.put("04.11", -5);
        maxMap.put("05.11", -4);
        maxMap.put("06.11", 0);

        minMap.put("31.10", 4);
        minMap.put("01.11", 0);
        minMap.put("02.11", 1);
        minMap.put("03.11", -10);
        minMap.put("04.11", -12);
        minMap.put("05.11", -9);
        minMap.put("06.11", -8);

        System.out.print("Enter date (e.g., 31.10): ");
        String input = sc.nextLine().trim();

        if (conditionMap.containsKey(input)) {
            String condition = conditionMap.get(input);
            int max = maxMap.get(input);
            int min = minMap.get(input);

            System.out.println("\nWeather on " + input + ": " + condition +
                    " (max ≈ " + max + "°C, min ≈ " + min + "°C)");
            station.setWeatherData(condition, max);
        } else {
            System.out.println("No data available for this date.");
            return;
        }

        System.out.print("\n Would you like to see the 7-day forecast? (yes/no): ");
        String answer = sc.nextLine().trim().toLowerCase();

        if (answer.equals("yes")) {
            System.out.println("\n Weekly Forecast:");
            System.out.println("Date\t\tCondition\t\t\tMax\tMin");
            System.out.println("----------------------------------------------------");

            for (String date : conditionMap.keySet()) {
                System.out.printf("%s\t%-30s\t%3d°C\t%3d°C%n",
                        date, conditionMap.get(date), maxMap.get(date), minMap.get(date));
            }
        }
    }
}
