package ru.rybyakowa.zadanie_1;

public class Storage<T> {
    private final T item;

    // Конструктор хранилища
    public Storage(T item, T alternative) {
        if (item == null) {
            if (alternative == null) {
                throw new NullPointerException("альтернатива должна быть не равна null");
            }
            this.item = alternative;
        } else {
            this.item = item;
        }
    }

    // Упрощенный метод получения объекта из хранилища
    public T get() {
        return this.item;
    }
}
