package ru.rybyakowa.zadanie_7;

import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}