package ru.rybyakowa.zadanie_1;

interface DoubleValueInterface {
    double getDoubleValue();
    void setFraction(int numerator, int denominator);
}

public class Drob implements DoubleValueInterface {
    private int numerator;
    private int denominator;
    private Double cachedDoubleValue;

    public Drob(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }


    public int getDenominator() {
        return denominator;
    }

    @Override
    public void setFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        this.cachedDoubleValue = null;
    }

    @Override
    public double getDoubleValue() {
        if (cachedDoubleValue == null) {
            cachedDoubleValue = (double) numerator / denominator;
        }
        return cachedDoubleValue;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        Drob drob = (Drob) o;
        return numerator == drob.numerator && denominator == drob.denominator;
    }
}