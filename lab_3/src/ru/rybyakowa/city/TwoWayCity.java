package ru.rybyakowa.city;

public class TwoWayCity extends City {
    public TwoWayCity(String name) {
        super(name);
    }

    public void addRoute(City destination, int cost) {
        super.addRoute(destination, cost);
        if (!destination.getRoutes().containsKey(this)) { // Avoid infinite recursion
            destination.addRoute(this, cost);
        }
    }

    public void removeRoute(City destination) {
        super.removeRoute(destination);
        destination.removeRoute(this);
    }
}