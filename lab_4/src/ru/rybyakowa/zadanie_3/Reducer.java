package ru.rybyakowa.zadanie_3;

import java.util.List;
import java.util.function.BinaryOperator;

public class Reducer { // // Класс Reducer для сведения списка к одному значению с помощью бинарного оператора.
    public <T> T reduce(List<T> list, BinaryOperator<T> accumulator, T identity) {
        // Метод reduce, выполняющий редукцию списка.
        // list: Список элементов, подлежащих сведению.
        // accumulator: Бинарный оператор, применяемый к результату и текущему элементу.
        // identity: Идентичность (начальное значение) результата сведения.

        if (list == null || list.isEmpty()) { // Если список пуст или null, возвращается идентичность.
            return identity;
        }
        T result = identity; // Инициализация результата редукции идентичностью.
        for (T item : list) {  // Итерация по элементам списка.
            // Применение бинарного оператора к результату и текущему элементу. Результат применения становится новым значением результата.
            result = accumulator.apply(result, item);
        }
        return result; // Возвращение результирующего значения.
    }
}
