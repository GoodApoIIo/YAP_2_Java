package ru.rybyakowa.zadanie_2;

public class Point3D extends Point { // Класс Point3D наследуется от класса Point
    private final double z; // Координата z точки

    public Point3D(double x, double y, double z) { // Конструктор класса Point3D
        super(x, y); // Вызов конструктора родительского класса Point для инициализации координат x и y
        this.z = z; // Инициализация координаты z
    }

    public String toString() { // Вывод координат трехмерной точки
        return String.format("(%f, %f, %f)", getX(), getY(), z); // Форматированный вывод координат в виде (x, y, z)
    }
}