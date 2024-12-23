package ru.rybyakowa.zadanie_2;

public class MeowCaller {
    // Отслеживания количества вызовов meow()
    private int meowCount;
    // Для хранения объекта, реализующего интерфейс Meowable
    private final Meowable cat;

    // Конструктор, принимает объект, реализующий интерфейс
    public MeowCaller(Meowable cat) {
        this.meowCount = 0; // Инициализируем счетчик вызовов meow()
        this.cat = cat; // Инициализируем объект, реализующий интерфейс
    }

    // Метод для вызова метода meow() у объекта cat
    public void meow() {
        // Увеличиваем счетчик вызовов meow()
        meowCount++;
        // Вызываем метод meow() у объекта cat
        cat.meow();
    }

    // Метод для получения количества вызовов meow()
    public int getMeowCount() {
        // Возвращаем текущее значение счетчика вызовов meow()
        return meowCount;
    }
}