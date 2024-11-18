package ru.rybyakowa.city;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addRoute(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null.");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость маршрута должна быть положительной.");
        }
        if (routes.containsKey(destination)) {
            throw new IllegalArgumentException("Маршрут до " + destination.getName() + " уже существует.");
        }
        routes.put(destination, cost);
    }

    public void removeRoute(City destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null.");
        }
        routes.remove(destination);
    }

    public Map<City, Integer> getRoutes() {
        return new HashMap<>(routes); // Return a copy to prevent external modification
    }

    public String toString() {
        String result = name + ": ";
        if (routes.isEmpty()) {
            result += "Нет маршрутов";
        } else {
            boolean first = true;
            for (Map.Entry<City, Integer> entry : routes.entrySet()) {
                if (!first) {
                    result += ", ";
                }
                result += entry.getKey().getName() + ":" + entry.getValue();
                first = false;
            }
        }
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return name.equals(city.name);
    }

    public int hashCode() {
        return name.hashCode();
    }
}