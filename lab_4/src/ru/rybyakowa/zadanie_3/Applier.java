package ru.rybyakowa.zadanie_3;

import java.util.ArrayList; // Импорт класса ArrayList для работы со списками
import java.util.List; // Импорт интерфейса List для работы со списками
import java.util.function.Function; // Импорт интерфейса Function для работы с функциями

public class Applier { // Класс Applier, применяющий функцию к каждому элементу списка
    public <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) { // Метод applyFunction, применяющий функцию к списку
        List<P> result = new ArrayList<>(); // Создание нового списка для хранения результатов
        for (T item : list) { // Цикл по каждому элементу входного списка
            result.add(function.apply(item)); // Применение функции к элементу и добавление результата в новый список
        }
        return result; // Возвращение списка результатов
    }
}