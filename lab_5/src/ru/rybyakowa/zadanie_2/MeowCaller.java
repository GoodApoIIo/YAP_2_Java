package ru.rybyakowa.zadanie_2;

public class MeowCaller {
    private int meowCount;
    private final Meowable cat;

    public MeowCaller(Meowable cat) {
        this.meowCount = 0;
        this.cat = cat;
    }

    public void meow() {
        meowCount++;
        cat.meow();
    }

    public int getMeowCount() {return meowCount;}
}