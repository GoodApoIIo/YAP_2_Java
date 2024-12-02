package ru.rybyakowa.zadanie_1;

public class Box<T> {
    private T item; // Переменная для хранения элемента, тип определяется параметром T

    public void put(T item) { // Метод добавления элемента в коробку
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже занята.");
        }
        this.item = item; // Добавление элемента в коробку
    }

    public T get() { // Метод получения элемента из коробки
        if (this.item == null) {
            throw new IllegalStateException("Коробка пуста.");
        }
        T temp = this.item; // Сохранение элемента во временную переменную
        this.item = null; // Удаление элемента из коробки (установка в null)
        return temp; // Возврат элемента
    }

    public boolean isEmpty() { // Метод проверки, пуста ли коробка
        return this.item == null;
    }
}
