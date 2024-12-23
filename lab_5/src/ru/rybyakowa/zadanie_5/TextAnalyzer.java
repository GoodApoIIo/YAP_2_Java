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

    // Метод для поиска часто встречающихся звонких согласных
    public Set<Character> findFrequentVoicedConsonants() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line;
            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {
                // Добавляем прочитанную строку в StringBuilder, добавляя пробел для разделения слов
                text.append(line).append(" ");
            }
            // Приводим текст к нижнему регистру и удаляем все символы, кроме русских букв и пробелов
            String normalizedText = text.toString().toLowerCase().replaceAll("[^а-я\\s]", "");
            // Разбиваем текст на слова, используя пробелы как разделитель
            String[] words = normalizedText.split("\\s+");
            // Множество для хранения звонких согласных
            Set<Character> voicedConsonants = new HashSet<>(Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'));

            // Множество для хранения согласных, которые встречаются более одного раза
            Set<Character> frequentConsonants = new HashSet<>();
            // Множество для хранения согласных, которые встречаются один раз
            Set<Character> seenConsonantsOnce = new HashSet<>();

            // Перебираем слова в тексте
            for (String word : words) {
                // Перебираем символы в слове
                for (char c : word.toCharArray()) {
                    // Если символ - звонкая согласная
                    if (voicedConsonants.contains(c)) {
                        // Если согласная уже встречалась
                        if(seenConsonantsOnce.contains(c)){
                            // Если ее нет во frequentConsonants, то добавляем туда
                            if(!frequentConsonants.contains(c))
                                frequentConsonants.add(c);
                        } else {
                            // Если это ее первое появление, то добавляем ее в seenConsonantsOnce
                            seenConsonantsOnce.add(c);
                        }
                    }
                }
            }

            // Создаем отсортированное множество для хранения результата
            Set<Character> result = new TreeSet<>(frequentConsonants);
            // Возвращаем отсортированное множество
            return result;

        } catch (IOException e) {
            // Обработка исключения IOException, если произошла ошибка чтения файла
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            // Возвращаем пустое множество при ошибке
            return Collections.emptySet();
        }
    }
}