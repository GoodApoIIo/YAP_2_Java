package ru.rybyakowa.bird;

import java.util.Random;

public class Cuckoo extends Bird {
    private Random random = new Random();

    public Cuckoo(String name) {
        super(name);
    }

    public void sing() {
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("Ку-ку");
        }
    }
}