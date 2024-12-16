import ru.rybyakowa.zadanie_1.*;
import ru.rybyakowa.zadanie_2.*;
import ru.rybyakowa.zadanie_3.*;
import ru.rybyakowa.zadanie_5.*;
import ru.rybyakowa.zadanie_6.*;
import ru.rybyakowa.zadanie_7.*;

import java.util.*;
import java.util.stream.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-7): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                System.out.println("Введите числитель для первой дроби:");
                int num1 = scanner.nextInt();
                System.out.println("Введите знаменатель для первой дроби:");
                int den1 = scanner.nextInt();
                Drob drob1 = new Drob(num1, den1);

                System.out.println("Введите числитель для второй дроби:");
                int num2 = scanner.nextInt();
                System.out.println("Введите знаменатель для второй дроби:");
                int den2 = scanner.nextInt();
                Drob drob2 = new Drob(num2, den2);

                System.out.println("Первая дробь: " + drob1);
                System.out.println("Вторая дробь: " + drob2);
                System.out.println("Дроби равны: " + drob1.equals(drob2));

                System.out.println("Вещественное значение первой дроби: " + drob1.getDoubleValue());
                System.out.println("Вещественное значение второй дроби: " + drob2.getDoubleValue());

                System.out.println("Введите новый числитель для первой дроби:");
                int newNum1 = scanner.nextInt();
                System.out.println("Введите новый знаменатель для первой дроби:");
                int newDen1 = scanner.nextInt();
                drob1.setFraction(newNum1, newDen1);
                System.out.println("Вещественное значение первой дроби после изменения числителя и знаменателя: " + drob1.getDoubleValue());
                break;
            case 2:
                Meowable cat = new Cat("Рыжик");
                MeowCaller count = new MeowCaller(cat);

                Random random = new Random();
                int meowTimes = random.nextInt(5) + 1; // Случайное число мяуканий от 1 до 5

                for (int i = 0; i < meowTimes; i++) {
                    count.meow();
                }

                System.out.println("Кот мяукнул " + count.getMeowCount() + " раз(а)");
                break;
            case 3:
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(2);
                list.add(4);
                list.add(2);

                System.out.println("Список до удаления: " + list);
                RemoveElements.removeElements(list, 2);
                System.out.println("Список после удаления: " + list);
                break;
            case 4:
                break;
            case 5:
                String fileName = "C:\\Users\\rybya\\IdeaProjects\\lab_5\\src\\text.txt";

                TextAnalyzer analyzer = new TextAnalyzer(fileName);
                Set<Character> frequentConsonants = analyzer.findFrequentVoicedConsonants();

                System.out.println("Звонкие согласные буквы, встречающиеся более чем в одном слове:");
                for (char c : frequentConsonants) {
                    System.out.print(c + " ");
                }
                System.out.println();
                break;
            case 6:
                Queue<Integer> queue1 = new LinkedList<>();

                int queueSize;
                // Запрашиваем размер очереди
                System.out.println("Введите размер очереди:");
                while(true) {
                    if(scanner.hasNextInt()) {
                        queueSize = scanner.nextInt();
                        if(queueSize > 0) {
                            break;
                        } else {
                            System.out.println("Размер должен быть положительным целым числом");
                        }
                    } else {
                        System.out.println("Неверный ввод. Введите целое число.");
                        scanner.next();
                    }
                }

                // Ввод элементов очереди
                System.out.println("Введите " + queueSize + " элементов очереди (целые числа):");
                for (int i = 0; i < queueSize; i++) {
                    while(!scanner.hasNextInt()) {
                        System.out.println("Неверный ввод. Введите целое число.");
                        scanner.next(); // Очистка ввода
                    }
                    queue1.add(scanner.nextInt());
                }

                System.out.println("Исходная очередь L1: " + queue1);

                Queue<Integer> queue2 = QueueReverser.reverseQueue(new LinkedList<>(queue1));

                System.out.println("Перевернутая очередь L2: " + queue2);
                scanner.close();
                break;
            case 7:
                System.out.print("Введите номер подзадачи (1 или 2): ");
                int n7 = scanner.nextInt();

                switch (n7) {
                    case 1:
                        Polyline polyline = new Polyline(
                                Stream.of(
                                                new Point(1, -2),
                                                new Point(3, 4),
                                                new Point(1, 2),
                                                new Point(5, -6),
                                                new Point(3, 4))
                                        .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                                        .distinct()
                                        .sorted(Comparator.comparingInt(Point::getX))
                                        .collect(Collectors.toList())
                        );
                        System.out.println(polyline);
                        break;
                    case 2:
                        break;

                    default:
                        System.out.println("Неверный номер подзадачи.");
                }
                break;
            default:
                System.out.println("Неверный номер задачи.");
        }
    }
}