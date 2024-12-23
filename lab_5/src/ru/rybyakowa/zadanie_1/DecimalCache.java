package ru.rybyakowa.zadanie_1;

public class DecimalCache {
    private Decimal d;
    private Double cache;

    public DecimalCache(Decimal decimal) {
        d = decimal;
        cache = null;
    }

    public double getDoubleValue() {
        if (cache == null) { // Если значение в кэше не установлено
            cache = d.getDoubleValue(); // Вычисляем вещественное значение дроби с помощью метода
            System.out.println("Вычисление значения...");
        }
        return cache;
    }

    public void setNumeratorDenominator(int numerator, int denominator) {
        d.setNumeratorDenominator(numerator, denominator); // Устанавливаем новые числитель и знаменатель дроби с помощью метода
        cache = null; // Сброс кеша
    }
}
