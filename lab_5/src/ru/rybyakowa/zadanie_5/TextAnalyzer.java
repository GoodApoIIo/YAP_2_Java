package ru.rybyakowa.zadanie_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {

    private String fileName;

    public TextAnalyzer(String fileName) {
        this.fileName = fileName;
    }

    public Set<Character> findFrequentVoicedConsonants() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
            String normalizedText = text.toString().toLowerCase().replaceAll("[^а-я\\s]", "");
            String[] words = normalizedText.split("\\s+");

            Set<Character> voicedConsonants = new HashSet<>(Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'));
            Map<Character, Integer> consonantCounts = new HashMap<>();

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    if(voicedConsonants.contains(c)) {
                        consonantCounts.put(c, consonantCounts.getOrDefault(c, 0) + 1);
                    }
                }
            }

            Set<Character> result = new TreeSet<>(); // Используем TreeSet для автоматической сортировки
            for(Map.Entry<Character, Integer> entry : consonantCounts.entrySet()) {
                if(entry.getValue() > 1) {
                    result.add(entry.getKey());
                }
            }

            return result;


        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return Collections.emptySet(); // Возвращаем пустое множество при ошибке
        }
    }
}