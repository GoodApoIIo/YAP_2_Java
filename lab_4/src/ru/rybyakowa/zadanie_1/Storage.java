package ru.rybyakowa.zadanie_1;

public class Storage<T> {
    private final T item;
    private final T defaultValue;

    public Storage(T item, T defaultValue) { // Конструктор класса Storage
        this.item = item; // Инициализация хранимого значения
        this.defaultValue = defaultValue; // Инициализация значения по умолчанию
    }

    public T get() { // Метод получения значения
        return (item != null) ? item : defaultValue; // Возвращает хранимое значение, если оно не null, иначе значение по умолчанию
    }
}