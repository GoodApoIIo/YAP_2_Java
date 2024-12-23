import ru.rybyakowa.zadanie_1.*;
import ru.rybyakowa.zadanie_2.*;
import ru.rybyakowa.zadanie_3.*;
import ru.rybyakowa.zadanie_4.*;
import ru.rybyakowa.zadanie_5.*;
import ru.rybyakowa.zadanie_6.*;
import ru.rybyakowa.zadanie_7.*;

import java.util.*;
import java.util.stream.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-7): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                FractionInterface decimal1 = new Decimal(1, 2);
                FractionInterface decimal2 = new Decimal(-5, -2);

                DecimalCache decimalCache1 = new DecimalCache((Decimal) decimal1);
                System.out.println(decimalCache1.getDoubleValue());
                System.out.println(decimalCache1.getDoubleValue());
                System.out.println(decimalCache1.getDoubleValue());

                decimalCache1.setNumeratorDenominator(3,5);
                System.out.println(decimalCache1.getDoubleValue());
                System.out.println(decimalCache1.getDoubleValue());
                System.out.println(decimalCache1.getDoubleValue());

                System.out.println("Равны ли дроби? " + decimal1.equals(decimal2));
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
                try {
                    SmetanaAnalyzer analyzer_4 = new SmetanaPrices();
                    ((SmetanaPrices) analyzer_4).loadFromFile("C:\\Users\\rybya\\IdeaProjects\\lab_5\\src\\smetana.txt");
                    int[] cheapestCounts = analyzer_4.getCheapestCounts();
                    System.out.println("Самый дешёвый сметана: 15: " + cheapestCounts[0] + ", 20: " + cheapestCounts[1] + ", 25: " + cheapestCounts[2]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                while (true) {
                    if (scanner.hasNextInt()) {
                        queueSize = scanner.nextInt();
                        if (queueSize > 0) {
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
                    while (!scanner.hasNextInt()) {
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