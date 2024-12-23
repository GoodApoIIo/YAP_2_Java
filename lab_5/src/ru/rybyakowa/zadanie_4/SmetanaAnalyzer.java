package ru.rybyakowa.zadanie_4;

public interface SmetanaAnalyzer {
    void addSmetana(String company, String street, int grade, int price);
    int[] getCheapestCounts();
}