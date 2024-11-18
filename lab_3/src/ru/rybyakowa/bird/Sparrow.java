package ru.rybyakowa.bird;

public class Sparrow extends Bird {
    public Sparrow(String name) {
        super(name);
    }

    public void sing() {
        System.out.println("Чырык");
    }
}