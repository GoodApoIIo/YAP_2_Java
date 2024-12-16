package ru.rybyakowa.zadanie_1;

public class Storage<T> {
    private final T item;

    // Конструктор хранилища
    public Storage(T item) {
        this.item = item;
    }

    // Метод получения объекта из хранилища
    public T get(T defaultValue) {
        T result;  // Объявляем переменную result типа T для хранения результата.

        if (item != null) {
            // Если item не равен null
            result = item; // Присваиваем переменной result значение item.
        } else {
            // Если item равен null
            result = defaultValue; // Присваиваем переменной result значение defaultValue.
        }

        return result; // Возвращаем значение result.
    }

    // Метод для обработки хранилища и вывода значения
    public static <T> void processStorage(Storage<T> storage, T defaultValue) {
        T value = storage.get(defaultValue);
        System.out.println("Value from storage: " + value);
    }
}
