package ru.rybyakowa.zadanie_2;

public class Cat implements Meowable {
    private final String name; // Имя кота

    // Конструктор
    public Cat(String name) {
        this.name = name; // Инициализируем имя кота
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Реализация метода из интерфейса Meowable
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}