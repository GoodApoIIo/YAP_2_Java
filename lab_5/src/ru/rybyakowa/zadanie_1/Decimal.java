package ru.rybyakowa.zadanie_1;

public class Decimal implements FractionInterface{
    private int numerator;
    private int denominator;

    public Decimal(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public double getDoubleValue() {
        return (double) numerator / denominator;
    }

    public void setNumeratorDenominator(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decimal decimal = (Decimal) o;
        return numerator == decimal.numerator && denominator == decimal.denominator;
    }

}