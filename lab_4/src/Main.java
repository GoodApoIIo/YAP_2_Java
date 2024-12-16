import ru.rybyakowa.zadanie_2.putPoint;
import ru.rybyakowa.zadanie_3.Applier;
import ru.rybyakowa.zadanie_3.Collector;
import ru.rybyakowa.zadanie_3.Filter;
import ru.rybyakowa.zadanie_3.Reducer;
import ru.rybyakowa.zadanie_2.Point3D;
import ru.rybyakowa.zadanie_1.Box;
import ru.rybyakowa.zadanie_1.Storage;

import java.util.*;
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
                        // Пример 1: Хранилище чисел (null -> 0)
                        Storage<Integer> nullIntegerStorage = new Storage<>(null);
                        Storage.processStorage(nullIntegerStorage, 0);

                        // Пример 2: Хранилище чисел (99 -> -1)
                        Storage<Integer> integerStorage = new Storage<>(99);
                        Storage.processStorage(integerStorage, -1);

                        // Пример 3: Хранилище строк (null -> "default")
                        Storage<String> nullStringStorage = new Storage<>(null);
                        Storage.processStorage(nullStringStorage, "default");

                        // Пример 4: Хранилище строк ("hello" -> "hello world")
                        Storage<String> stringStorage = new Storage<>("hello");
                        Storage.processStorage(stringStorage, "hello world");
                        break;
                    default:
                        System.out.println("Неверный номер подзадачи.");
                }
                break;
            case 2:
                Box<Point3D> box1 = new Box<>();
                putPoint.putPointInBox(box1);
                System.out.println("Box1: " + box1.get());

                Box<Point3D> box2 = new Box<>();
                putPoint.putPointInBox(box2);
                System.out.println("Box2: " + box2.get());

                break;
            case 3:
                System.out.print("Введите номер подзадачи (1-4): ");
                int n3 = scanner.nextInt();

                switch (n3) {
                    case 1:
                        System.out.println("Длина строк: " + Applier.applyFunction(List.of("qwerty", "asdfg", "zx"), String::length));
                        System.out.println("Модуль значений: " + Applier.applyFunction(List.of(1, -3, 7), Math::abs));
                        System.out.println("Максимальное значение: " + Applier.applyFunction(List.of(List.of(1, 2, 3), List.of(-5, -3, 0), List.of(8, 7, 9)), list -> list.stream().max(Integer::compareTo).orElseThrow()));
                        break;
                    case 2:
                        System.out.println("Строки содержат менее 3 букв: " + Filter.filter(List.of("qwerty", "asdfg", "zx"), x -> x.length() < 3));
                        System.out.println("Положительные числа: " + Filter.filter(List.of(1, -3, 7), x -> x > 0));
                        System.out.println("Список, содержащий только отрицательные числа: ");
                        for (List<Integer> list : Filter.filter(List.of(List.of(1, -2, 3), List.of(-1, -2, -3), List.of(0, -4, -5)), list -> list.stream().allMatch(x -> x < 0))) {
                            System.out.println(list);
                        }
                        break;
                    case 3:
                        System.out.println("Строка из всех строк: " + Reducer.reduce(List.of("qwerty", "asdfg", "zx"), (a, b) -> a + b, ""));
                        System.out.println("Сумма: " + Reducer.reduce(List.of(1, -3, 7), Integer::sum, 0));
                        System.out.println("Общее количество элементов: " + Reducer.reduce(List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6)), (a, b) -> a + b.size(), 0));
                        break;
                    case 4:
                        System.out.println("Массив положительных чисел: " + Collector.collect(List.of(1, -3, 7), ArrayList::new, num -> num > 0));
                        System.out.println("Массив отрицательных чисел: " + Collector.collect(List.of(1, -3, 7), ArrayList::new, num -> num < 0));

                        System.out.println("Строки длинной 6: " + Collector.collect(List.of("qwerty", "asdfg", "zx", "qw"), ArrayList::new, str -> str.length() == 6));
                        System.out.println("Строки длинной 2 " + Collector.collect(List.of("qwerty", "asdfg", "zx", "qw"), ArrayList::new, str -> str.length() == 2));

                        System.out.println("Уникальные строки: " + Collector.collect(List.of("qwerty", "asdfg", "qwerty", "qw"), HashSet::new, str -> true));
                        break;
                    default: System.out.println("Неверный номер подзадачи.");
                }
                break;
            default: System.out.println("Неверный номер задания.");
        }
    }
}
