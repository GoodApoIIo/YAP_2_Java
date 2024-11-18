package ru.rybyakowa.calc;

public class PowerCalculator {

    public static double calculatePower(String xStr, String yStr) {
        try {
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            if (y < 0) {
                System.err.println("Ошибка: Показатель степени не может быть отрицательным.");
                return Double.NaN;
            }
            return Math.pow(x, y);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный ввод. X должен быть числом, Y - целым.");
            return Double.NaN;
        }
    }
}