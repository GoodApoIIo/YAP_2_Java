package ru.rybyakowa.zadanie_2;

import ru.rybyakowa.zadanie_1.Box;
import java.util.Random;

public class putPoint {

    public static <T> void putPointInBox(Box<T> box) {

        Random random = new Random();
        double x = random.nextDouble() * 100;  // произвольное значение от 0 до 100
        double y = random.nextDouble() * 100;
        double z = random.nextDouble() * 100;

        Point3D point = new Point3D(x, y, z);
        try {
            box.put((T) point);
        } catch (ClassCastException e) {
            System.out.println("Ошибка: Нельзя поместить Point3D в коробку с другим типом!");
        }

    }
}