package ru.rybyakowa.zadanie_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SmetanaPrices implements SmetanaAnalyzer {
    private Map<Integer, Integer> minPrices;
    private Map<Integer, Integer> counts;

    public SmetanaPrices() {
        minPrices = new HashMap<>();
        counts = new HashMap<>();
        minPrices.put(15, Integer.MAX_VALUE);
        minPrices.put(20, Integer.MAX_VALUE);
        minPrices.put(25, Integer.MAX_VALUE);
        counts.put(15, 0);
        counts.put(20, 0);
        counts.put(25, 0);
    }

    public void addSmetana(String company, String street, int grade, int price) {
        if (price < minPrices.get(grade)) {
            minPrices.put(grade, price);
            counts.put(grade, 1);
        } else if (price == minPrices.get(grade)) {
            counts.put(grade, counts.get(grade) + 1);
        }
    }

    public int[] getCheapestCounts() {
        return new int[]{counts.get(15), counts.get(20), counts.get(25)};
    }

    public void loadFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String company = parts[0].trim();
                    String street = parts[1].trim();
                    int grade = Integer.parseInt(parts[2].trim());
                    int price = Integer.parseInt(parts[3].trim());
                    addSmetana(company, street, grade, price);
                }
            }
        }
    }
    public String toString() {
        return "SmetanaAnalyzer{" +
                "minPrices=" + minPrices +
                ", counts=" + counts +
                '}';
    }
}