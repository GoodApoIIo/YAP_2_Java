package ru.rybyakowa.zadanie_2;

public class Point { // Класс, представляющий точку на плоскости
    private final double x; // Координата x точки
    private final double y; // Координата y точки

    public Point(double x, double y) { // Конструктор класса Point
        this.x = x; // Инициализация координаты x
        this.y = y; // Инициализация координаты y
    }

    public double getX() { // Метод получения координаты x
        return x; // Возвращение координаты x
    }
    public double getY() { // Метод получения координаты y
        return y; // Возвращение координаты y
    }

    public String toString() { // Вывод координат точки
        return String.format("(%f, %f)", x, y); // Форматированный вывод координат в виде (x, y)
    }
}