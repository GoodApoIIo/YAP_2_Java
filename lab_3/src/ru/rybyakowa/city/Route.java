package ru.rybyakowa.city;

import java.util.*;

public class Route {
    City start;
    City end;

    public Route(City start, City end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Начальный и конечный города не могут быть равны null.");
        }
        this.start = start;
        this.end = end;
    }

    public City[] getPath() {
        Queue<City> queue = new LinkedList<>();
        Map<City, City> parent = new HashMap<>();
        queue.offer(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            City current = queue.poll();
            if (current.equals(end)) break;
            for (Map.Entry<City, Integer> entry : current.getRoutes().entrySet()) {
                if (!parent.containsKey(entry.getKey())) {
                    queue.offer(entry.getKey());
                    parent.put(entry.getKey(), current);
                }
            }
        }

        if (!parent.containsKey(end)) return new City[0];

        List<City> path = new ArrayList<>();
        City current = end;
        while (current != null) {
            path.add(0, current);
            current = parent.get(current);
        }
        return path.toArray(new City[0]);
    }

    public String toString() {
        City[] path = getPath();
        if (path.length == 0) return "Путь не найден.";
        String result = "";
        for (int i = 0; i < path.length; i++) {
            result = result + path[i].getName();
            if (i < path.length - 1) {
                result = result + " ";
            }
        }
        return result;
    }
}