package ru.rybyakowa.bird;

abstract public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public void sing() {
        System.out.println("Общий звук птицы");
    }
}