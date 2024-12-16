package ru.rybyakowa.zadanie_2;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
