import ru.rybyakowa.zadanie_3.Applier;
import ru.rybyakowa.zadanie_3.Filter;
import ru.rybyakowa.zadanie_3.Reducer;
import ru.rybyakowa.zadanie_2.Point3D;
import ru.rybyakowa.zadanie_1.Box;
import ru.rybyakowa.zadanie_1.Storage;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-3): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                System.out.print("Введите номер подзадачи (1 или 2): ");
                int n1 = scanner.nextInt();

                switch (n1) {
                    case 1:
                        Box<Integer> integerBox = new Box<>();
                        integerBox.put(3);
                        Integer value = integerBox.get();
                        System.out.println("Извлеченное значение из поля: " + value);
                        break;
                    case 2:
                        // Пример 1: Хранилище чисел, значение null
                        Storage<Integer> intStorageNull = new Storage<>(null, 0);
                        int result1 = intStorageNull.get();
                        System.out.println("Результат 1: " + result1);

                        // Пример 2: Хранилище чисел, значение 99
                        Storage<Integer> intStorageValue = new Storage<>(99, -1);
                        int result2 = intStorageValue.get();
                        System.out.println("Результат 2: " + result2);

                        // Пример 3: Хранилище строк, значение null
                        Storage<String> stringStorageNull = new Storage<>(null, "default");
                        String result3 = stringStorageNull.get();
                        System.out.println("Результат 3: " + result3);

                        // Пример 4: Хранилище строк, значение "hello"
                        Storage<String> stringStorageValue = new Storage<>("hello", "hello world");
                        String result4 = stringStorageValue.get();
                        System.out.println("Результат 4: " + result4);
                        break;
                    default:
                        System.out.println("Неверный номер подзадачи.");
                }
            case 2:
                Box<Point3D> point3DBox = new Box<>();

                System.out.println("Коробка ничего не содержит? " + point3DBox.isEmpty());

                System.out.println("Введите координаты точки (x y z): ");
                double x = getDoubleFromInput(scanner);
                double y = getDoubleFromInput(scanner);
                double z = getDoubleFromInput(scanner);


                Point3D point3D = new Point3D(x, y, z);
                point3DBox.put(point3D);

                System.out.println("Коробка ничего не содержит? " + point3DBox.isEmpty());

                try {
                    Point3D retrievedPoint3D = point3DBox.get();
                    System.out.println("Извлеченная точка  " + retrievedPoint3D);
                } catch (IllegalStateException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                }

                System.out.println("Коробка ничего не содержит? " + point3DBox.isEmpty());
                scanner.close();
                break;
            case 3:
                System.out.print("Введите номер подзадачи (1-4): ");
                int n3 = scanner.nextInt();

                switch (n3) {
                    case 1:
                        Applier applier = new Applier();

                        Function<String, Integer> stringLengthFunction = String::length;

                        // Пример 1: преобразование строк в длины
                        List<String> strings_1 = List.of("qwerty", "asdfg", "zx");
                        List<Integer> lengths = applier.applyFunction(strings_1, stringLengthFunction);
                        System.out.println("Длины строк: " + lengths);

                        // Пример 2: преобразование чисел (положительные остаются, отрицательные - положительные)
                        List<Integer> numbers_1 = List.of(1, -3, 7);
                        Function<Integer, Integer> absValueFunction = number -> Math.abs(number);
                        List<Integer> absoluteNumbers = applier.applyFunction(numbers_1, absValueFunction);
                        System.out.println("Модули чисел: " + absoluteNumbers);


                        // Пример 3: преобразование массивов чисел в максимальные значения
                        List<int[]> intArrays_1 = List.of(new int[]{1, 5, 2}, new int[]{8, 3}, new int[]{4, 9, 6, 0});
                        Function<int[], Integer> maxArrayValueFunction = arr -> {
                            if (arr == null || arr.length == 0) return 0;
                            int maxValue = arr[0];
                            for (int i = 1; i < arr.length; i++) {
                                maxValue = Math.max(maxValue, arr[i]);
                            }
                            return maxValue;
                        };
                        List<Integer> maxValues = applier.applyFunction(intArrays_1, maxArrayValueFunction);
                        System.out.println("Максимальные значения: " + maxValues);
                        break;
                    case 2:
                        Filter filter = new Filter();

                        // Пример 1: фильтрация строк по длине
                        List<String> strings_2 = List.of("qwerty", "asdfg", "zx");
                        Predicate<String> stringLengthFilter = s -> s.length() >= 3; // lambda expression
                        List<String> filteredStrings = filter.filter(strings_2, stringLengthFilter);
                        System.out.println("Отфильтрованные строки: " + filteredStrings);

                        // Пример 2: фильтрация чисел (только отрицательные)
                        List<Integer> numbers_2 = List.of(1, -3, 7);
                        Predicate<Integer> positiveFilter = number -> number <= 0; // lambda expression
                        List<Integer> filteredNumbers = filter.filter(numbers_2, positiveFilter);
                        System.out.println("Отфильтрованные числа: " + filteredNumbers);

                        // Пример 3: фильтрация массивов (только массивы без положительных элементов)
                        List<int[]> intArrays_2 = List.of(
                                new int[]{-1, -5, -2},
                                new int[]{8, 3},
                                new int[]{-4, -9, -6, 0}
                        );

                        Predicate<int[]> noPositiveElementsFilter = arr -> {
                            if (arr == null) return false;
                            for (int num : arr) {
                                if (num > 0) return false;
                            }
                            return true;
                        };
                        List<int[]> filteredArrays = filter.filter(intArrays_2, noPositiveElementsFilter);
                        System.out.println("Отфильтрованные массивы: " + Arrays.deepToString(filteredArrays.toArray()));
                        break;
                    case 3:
                        Reducer reducer = new Reducer();

                        // Пример 1: Объединение строк
                        List<String> strings_3 = List.of("qwerty", "asdfg", "zx");
                        BinaryOperator<String> concatFunction = (s1, s2) -> s1 + s2;
                        String concatenatedString = reducer.reduce(strings_3, concatFunction, "");
                        System.out.println("Объединенная строка: " + concatenatedString);

                        // Пример 2: сумма чисел
                        List<Integer> numbers = List.of(1, -3, 7);
                        BinaryOperator<Integer> sumFunction = Integer::sum;
                        Integer sum = reducer.reduce(numbers, sumFunction, 0);
                        System.out.println("Сумма чисел: " + sum);
                        break;
                    case 4:
                        break;
                    default: System.out.println("Неверный номер подзадачи.");
                }
                break;
            default: System.out.println("Неверный номер задания.");
        }
    }

    private static double getDoubleFromInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Неверный ввод. Пожалуйста, введите число: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
