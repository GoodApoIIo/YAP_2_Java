package ru.rybyakowa.zadanie_3;

import java.util.List;
import java.util.function.BiFunction;

public class Reducer { // // Класс Reducer для сведения списка к одному значению с помощью бинарного оператора.
    public static <T, R> R reduce(List<T> values, BiFunction<R, T, R> function, R initial) {
        R result = initial;
        for (T value : values) {
            result = function.apply(result, value);
        }
        return result;
    }
}
