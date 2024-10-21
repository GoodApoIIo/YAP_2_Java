import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер задания (1-5): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                System.out.print("Введите номер подзадачи (1 или 3): ");
                int n1 = scanner.nextInt();

                switch (n1) {
                    case 1:
                        // Ввод координат точки 1
                        System.out.print("Введите координату X для точки 1: ");
                        double x1 = getDoubleInput(scanner);
                        System.out.print("Введите координату Y для точки 1: ");
                        double y1 = getDoubleInput(scanner);

                        // Ввод координат точки 2
                        System.out.print("Введите координату X для точки 2: ");
                        double x2 = getDoubleInput(scanner);
                        System.out.print("Введите координату Y для точки 2: ");
                        double y2 = getDoubleInput(scanner);

                        // Ввод координат точки 3
                        System.out.print("Введите координату X для точки 3: ");
                        double x3 = getDoubleInput(scanner);
                        System.out.print("Введите координату Y для точки 3: ");
                        double y3 = getDoubleInput(scanner);

                        // Создание объектов Point
                        Point point1 = new Point(x1, y1);
                        Point point2 = new Point(x2, y2);
                        Point point3 = new Point(x3, y3);

                        // Вывод текстового представления каждой точки
                        System.out.println("Точка 1: " + point1);
                        System.out.println("Точка 2: " + point2);
                        System.out.println("Точка 3: " + point3);
                        break;

                    case 3:
                        Name name1 = new Name("Клеопатра", null, null); // Только фамилия
                        Name name2 = new Name("Пушкин", "Александр", "Сергеевич"); // Все три параметра
                        Name name3 = new Name("Маяковский", "Владимир", null); // Фамилия и имя

                        System.out.println("Имя 1: " + name1);
                        System.out.println("Имя 2: " + name2);
                        System.out.println("Имя 3: " + name3);
                        break;

                    default:
                        System.out.println("Некорректный номер подзадачи.");
                }
                break;

            case 2:
                // Линия 1: {1;3} - {23;8}
                Point start1 = new Point(1, 3);
                Point end1 = new Point(23, 8);
                Line line1 = new Line(start1, end1);

                // Линия 2: горизонтальная на высоте 10, от 5 до 25
                Point start2 = new Point(5, 10);
                Point end2 = new Point(25, 10);
                Line line2 = new Line(start2, end2);

                // Линия 3: начинается как линия 1, заканчивается как линия 2
                Line line3 = new Line(line1.getStart(), line2.getEnd());

                System.out.println("Линия 1: " + line1);
                System.out.println("Линия 2: " + line2);
                System.out.println("Линия 3: " + line3);

                // Изменение координат первой и второй линий
                System.out.print("\nВведите координату X для начала линии 1: ");
                double x1 = getDoubleInput(scanner);
                System.out.print("Введите координату Y для начала линии 1: ");
                double y1 = getDoubleInput(scanner);
                start1.setX(x1);
                start1.setY(y1);

                System.out.print("Введите координату X для конца линии 1: ");
                x1 = getDoubleInput(scanner);
                System.out.print("Введите координату Y для конца линии 1: ");
                y1 = getDoubleInput(scanner);
                end1.setX(x1);
                end1.setY(y1);
                line1.setStart(start1);
                line1.setEnd(end1);

                System.out.print("Введите координату X для начала линии 2: ");
                x1 = getDoubleInput(scanner);
                System.out.print("Введите координату Y для начала линии 2: ");
                y1 = getDoubleInput(scanner);
                start2.setX(x1);
                start2.setY(y1);

                System.out.print("Введите координату X для конца линии 2: ");
                x1 = getDoubleInput(scanner);
                System.out.print("Введите координату Y для конца линии 2: ");
                y1 = getDoubleInput(scanner);
                end2.setX(x1);
                end2.setY(y1);
                line2.setStart(start2);
                line2.setEnd(end2);

                line3.setStart(line1.getStart());
                line3.setEnd(line2.getEnd());

                System.out.println("\nИзмененные линии:");
                System.out.println("Линия 1: " + line1);
                System.out.println("Линия 2: " + line2);
                System.out.println("Линия 3: " + line3);

                // Изменение координат первой линии, не затрагивая третью
                System.out.print("\nВведите координату X для начала линии 1 (чтобы не изменить линию 3): ");
                x1 = getDoubleInput(scanner);
                System.out.print("Введите координату Y для начала линии 1: ");
                y1 = getDoubleInput(scanner);

                // Создаем новую точку для start1
                Point newStart1 = new Point(x1, y1);
                line1.setStart(newStart1); // Устанавливаем новую точку для line1
                System.out.println("\nЛиния 1 изменена: " + line1);
                System.out.println("Линия 3 не изменилась: " + line3);
                break;

            case 3:
                // Создание городов
                City a = new City("A");
                City b = new City("B");
                City c = new City("C");
                City d = new City("D");
                City e = new City("E");
                City f = new City("F");

                // Создаем маршруты (согласно рисунку)
                a.addConnection(b, 5);
                a.addConnection(d, 6);
                a.addConnection(f, 1);

                b.addConnection(a, 5);
                b.addConnection(c, 3);

                c.addConnection(b, 3);
                c.addConnection(d, 4);

                d.addConnection(c, 4);
                d.addConnection(e, 2);
                d.addConnection(a, 6);

                e.addConnection(f, 2);

                f.addConnection(b, 1);
                f.addConnection(e, 2);


                // Выводим информацию о городах
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(d);
                System.out.println(e);
                System.out.println(f);
                break;

            case 4:
                // Создаем город с именем
                City_2 A = new City_2("A");
                City_2 B = new City_2("B");
                City_2 C = new City_2("C");
                City_2 D = new City_2("D");
                City_2 E = new City_2("E");
                City_2 F = new City_2("F");

                // Создаем город с именем и путями

                // Добавляем пути для города A
                City_2[] pathsA = {B, F, D}; // Добавляем пути для города A
                int[] costsA = {5, 1, 6}; // Стоимости путей для города A
                A = new City_2("A", pathsA, costsA); // Перезаписываем город A с путями

                // Добавляем пути для города B
                City_2[] pathsB = {A, C}; // Добавляем пути для города B
                int[] costsB = {5, 3}; // Стоимости путей для города B
                B = new City_2("B", pathsB, costsB); // Перезаписываем город B с путями

                // Добавляем пути для города C
                City_2[] pathsC = {B, D}; // Добавляем пути для города C
                int[] costsC = {3, 4}; // Стоимости путей для города C
                C = new City_2("C", pathsC, costsC); // Перезаписываем город C с путями

                // Добавляем пути для города D
                City_2[] pathsD = {C, E, A}; // Добавляем пути для города D
                int[] costsD = {4, 2, 6}; // Стоимости путей для города D
                D = new City_2("D", pathsD, costsD); // Перезаписываем город D с путями

                // Добавляем пути для города E
                City_2[] pathsE = {F}; // Добавляем пути для города E
                int[] costsE = {2}; // Стоимости путей для города E
                E = new City_2("E", pathsE, costsE); // Перезаписываем город E с путями

                // Добавляем пути для города F
                City_2[] pathsF = {B, E}; // Добавляем пути для города F
                int[] costsF = {1, 2}; // Стоимости путей для города F
                F = new City_2("F", pathsF, costsF); // Перезаписываем город F с путями

                // Выводим информацию о городах
                System.out.println(A);
                System.out.println(B);
                System.out.println(C);
                System.out.println(D);
                System.out.println(E);
                System.out.println(F);
                break;

            case 5:
                // Ввод значений дробей с клавиатуры
                System.out.print("Введите числитель дроби f1: ");
                int num1 = getIntInput(scanner);
                System.out.print("Введите знаменатель дроби f1: ");
                int den1 = getIntInput(scanner);

                System.out.print("Введите числитель дроби f2: ");
                int num2 = getIntInput(scanner);
                System.out.print("Введите знаменатель дроби f2: ");
                int den2 = getIntInput(scanner);

                System.out.print("Введите числитель дроби f3: ");
                int num3 = getIntInput(scanner);
                System.out.print("Введите знаменатель дроби f3: ");
                int den3 = getIntInput(scanner);

                // Создание объектов дробей
                Fraction f1 = new Fraction(num1, den1);
                Fraction f2 = new Fraction(num2, den2);
                Fraction f3 = new Fraction(num3, den3);

                System.out.println("\n---- РЕЗУЛЬТАТЫ ----\n");

                // Примеры использования методов
                System.out.print("\n");
                System.out.println(f1 + " * " + f2 + " = " + simplifyFraction(f1.multiply(f2))); // Умножение дробей
                System.out.println(f1 + " + " + 2 + " = " + simplifyFraction(f1.sum(2))); // Сложение с целым числом
                System.out.println(f1 + " - " + f2 + " = " + simplifyFraction(f1.minus(f2))); // Вычитание дробей
                System.out.println(f1 + " / " + f2 + " = " + simplifyFraction(f1.divide(f2))); // Деление дробей

                // Вычисление выражения
                Fraction result = f1.sum(f2).divide(f3).minus(5);
                System.out.println(f1 + " + " + f2 + " / " + f3 + " - 5 = " + simplifyFraction(result));
                break;
            default:
                System.out.println("Некорректный номер задания.");
        }
    }

    // Проверка входных данных для double
    public static double getDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число.");
            scanner.next(); // Считываем и отбрасываем некорректный ввод
        }
        return scanner.nextDouble();
    }

    // Проверка входных данных для int
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scanner.next(); // Считываем и отбрасываем некорректный ввод
        }
        return scanner.nextInt();
    }

    public static Fraction simplifyFraction(Fraction fraction) {
        if (fraction.getDenominator() == 0) {
            throw new ArithmeticException("Дробь не определена");
        }
        int gcd = gcd(fraction.getNumerator(), fraction.getDenominator());
        return new Fraction(fraction.getNumerator() / gcd, fraction.getDenominator() / gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}