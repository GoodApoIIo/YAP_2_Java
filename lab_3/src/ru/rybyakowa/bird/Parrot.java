package ru.rybyakowa.bird;

import java.util.Random;

public class Parrot extends Bird {
    private String text;
    private Random random = new Random();

    public Parrot(String name, String text) {
        super(name);
        this.text = text;
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст для попугая не может быть пустым.");
        }
    }

    public void sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}