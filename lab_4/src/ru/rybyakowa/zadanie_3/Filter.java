package ru.rybyakowa.zadanie_3;

import java.util.ArrayList; // Импорт класса ArrayList для создания списка
import java.util.List; // Импорт интерфейса List для работы со списками
import java.util.function.Predicate; // Импорт интерфейса Predicate для работы с предикатами (условиями)

public class Filter { // Класс Filter для фильтрации списка на основе предиката
    public static  <T> List<T> filter(List<T> list, Predicate<T> predicate) { // Метод filter, принимающий список и предикат
        List<T> result = new ArrayList<>(); // Создание нового списка для хранения отфильтрованных элементов
        for (T item : list) { // Итерация по каждому элементу входного списка
            if (predicate.test(item)) { // Проверка элемента с помощью предиката
                result.add(item); // Добавление элемента в результирующий список, если предикат вернул true
            }
        }
        return result; // Возвращение отфильтрованного списка
    }
}