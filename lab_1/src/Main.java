import static java.lang.System.out;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        out.print("Введите номер раздела (1-4): ");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                out.print("Введите номер задачи (нечетное): ");
                int n1 = sc.nextInt();

                switch (n1) {
                    case 1:
                        out.print("Введите дробное число: ");
                        double num = sc.nextDouble();
                        double x = m.fraction(num);
                        out.print("Дробная часть от числа: ");
                        out.println(String.format("%.2f", x));
                        break;

                    case 3:
                        out.print("Введите символ: ");
                        sc.nextLine();
                        char ch = sc.next().charAt(0);

                        int result = m.charToNum(ch);
                        if (result != -1) {
                            out.println("Символ " + ch + " преобразован в число " + result);
                        } else {
                            out.println("Некорректный символ.");
                        }
                        break;

                    case 5:
                        out.print("Введите число: ");
                        int num5 = sc.nextInt();

                        boolean isTwoDigits = m.is2Digits(num5);
                        if (isTwoDigits) {
                            out.println("Число двузначное");
                        } else {
                            out.println("Число не двузначное");
                        }
                        break;

                    case 7:
                        out.print("Введите левую границу диапазона: ");
                        int a = sc.nextInt();
                        out.print("Введите правую границу диапазона: ");
                        int b = sc.nextInt();
                        out.print("Введите число для проверки: ");
                        int num7 = sc.nextInt();

                        boolean inRange = m.isInRange(a, b, num7);
                        if (inRange) {
                            out.println("Число входит в диапазон");
                        } else {
                            out.println("Число не входит в диапазон");
                        }
                        break;

                    case 9:
                        out.print("Введите первое число: ");
                        int a9 = sc.nextInt();
                        out.print("Введите второе число: ");
                        int b9 = sc.nextInt();
                        out.print("Введите третье число: ");
                        int c9 = sc.nextInt();

                        boolean isEqual = m.isEqual(a9, b9, c9);
                        if (isEqual) {
                            out.println("Все числа равны.");
                        } else {
                            out.println("Числа не равны.");
                        }
                        break;

                    default:
                        out.println("Неверный номер задачи.");
                        break;
                }
                break; // конец первого раздела

            case 2:
                out.print("Введите номер задачи (нечетное): ");
                int n2 = sc.nextInt();

                switch (n2) {
                    case 1:
                        out.print("Введите число: ");
                        int num11 = sc.nextInt();
                        int x11 = m.abs(num11);

                        System.out.println("Модуль числа " + num11 + " равен " + x11);
                        break;

                    case 3:
                        out.print("Введите число: ");
                        int x = sc.nextInt();
                        boolean result = m.is35(x);
                        if (result) {
                            out.println(true);
                        } else {
                            out.println(false);
                        }
                        break;

                    case 5:
                        out.print("Введите первое число: ");
                        int x5 = sc.nextInt();
                        out.print("Введите второе число: ");
                        int y5 = sc.nextInt();
                        out.print("Введите третье число: ");
                        int z5 = sc.nextInt();

                        int max5 = m.max3(x5, y5, z5);
                        System.out.print("Максимальное число из " + x5 + ", " + y5 + ", " + z5 + " = " + max5);

                        break;

                    case 7:
                        out.print("Введите первое число: ");
                        int x6 = sc.nextInt();
                        out.print("Введите второе число: ");
                        int y6 = sc.nextInt();

                        int sum6 = m.sum2(x6, y6);
                        System.out.print("Результат: " + sum6);

                        break;

                    case 9:
                        out.print("Введите номер дня недели: ");
                        int day = sc.nextInt();

                        String res = m.day(day);
                        System.out.print(res);

                        break;

                    default:
                        out.println("Неверный номер задачи.");
                        break;
                }
                break; // конец второго раздела

            case 3:
                out.print("Введите номер задачи (нечетное): ");
                int n3 = sc.nextInt();
                switch (n3) {
                    case 1:
                        out.print("Введите число: ");
                        int num = sc.nextInt();
                        String result = m.listNums(num);
                        out.println("Числа от 0 до " + num + ": " + result);
                        break;

                    case 3:
                        out.print("Введите число: ");
                        int num3 = sc.nextInt();
                        String result3 = m.chet(num3);
                        out.println("Четные числа от 0 до " + num3 + ": " + result3);
                        break;

                    case 5:
                        out.print("Введите число: ");
                        long num5 = sc.nextLong();
                        int length5 = m.numLen(num5);
                        out.println("Длина числа " + num5 + " равна: " + length5);
                        break;

                    case 7:
                        out.print("Введите размер квадрата: ");
                        int size = sc.nextInt();
                        m.square(size);
                        break;

                    case 9:
                        out.print("Введите высоту треугольника: ");
                        int height = sc.nextInt();
                        m.rightTriangle(height);
                        break;

                    default:
                        out.println("Неверный номер задачи.");
                        break;
                }
                break; // конец третьего раздела

            case 4:
                out.print("Введите номер задачи (нечетное): ");
                int n4 = sc.nextInt();
                switch (n4) {
                    case 1:
                        out.print("Введите массив чисел (через пробел): ");
                        sc.nextLine();
                        String[] input = sc.nextLine().split(" ");
                        int[] arr = new int[input.length];
                        for (int i = 0; i < input.length; i++) {
                            arr[i] = Integer.parseInt(input[i]);
                        }
                        out.print("Введите число для поиска: ");
                        int x = sc.nextInt();
                        int index = m.findFirst(arr, x);
                        if (index != -1) {
                            out.println("Индекс первого вхождения " + x + " в массиве: " + index);
                        } else {
                            out.println("Число не входит в массив.");
                        }
                        break;

                    case 3:
                        out.print("Введите массив чисел (через пробел): ");
                        sc.nextLine();
                        String[] in = sc.nextLine().split(" ");
                        int[] arr3 = new int[in.length];
                        for (int i = 0; i < in.length; i++) {
                            arr3[i] = Integer.parseInt(in[i]);
                        }
                        int maxAbsValue = m.maxAbs(arr3);
                        out.println("Наибольшее по модулю значение в массиве: " + maxAbsValue);
                        break;

                    case 5:
                        out.print("Введите 1-ый массив(5 чисел): ");
                        int[] arrr1 = new int[5];
                        for (int i=0; i<arrr1.length; i++){
                            arrr1[i] = sc.nextInt();
                        }
                        out.print("Введите 2-oй массив(3 числа): ");
                        int[] arrr2 = new int[3];
                        for (int i=0; i<arrr2.length; i++){
                            arrr2[i] = sc.nextInt();
                        }
                        out.print("Введите позицию, с которой будет вставлен второй массив в первый: ");
                        int pos = sc.nextInt();
                        int[] newarr = m.add(arrr1, arrr2, pos);
                        out.print("Результат: ");
                        for (int num : newarr) {
                            out.print(num + " ");
                        }
                        out.println("\n");
                        break;


                    case 7:
                        out.print("Введите массив чисел (через пробел): ");
                        sc.nextLine();
                        String[] input7 = sc.nextLine().split(" ");
                        int[] arr7 = new int[input7.length];
                        for (int i = 0; i < input7.length; i++) {
                            arr7[i] = Integer.parseInt(input7[i]);
                        }

                        int[] reversedArr = m.reverseBack(arr7);
                        System.out.print("Исходный массив: [");
                        for (int i = 0; i < arr7.length; i++) {
                            System.out.print(arr7[i]);
                            if (i < arr7.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");

                        System.out.print("Перевернутый массив: [");
                        for (int i = 0; i < reversedArr.length; i++) {
                            System.out.print(reversedArr[i]);
                            if (i < reversedArr.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                        break;

                    case 9:
                        out.print("Введите массив чисел (через пробел): ");
                        sc.nextLine();
                        String[] input9 = sc.nextLine().split(" ");
                        int[] arr9 = new int[input9.length];
                        for (int i = 0; i < input9.length; i++) {
                            arr9[i] = Integer.parseInt(input9[i]);
                        }

                        out.print("Введите число для поиска: ");
                        int x9 = sc.nextInt();

                        int[] indices = m.findAll(arr9, x9);

                        System.out.print("Индексы вхождений " + x9 + ": [");
                        for (int i = 0; i < indices.length; i++) {
                            System.out.print(indices[i]);
                            if (i < indices.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                        break;

                    default:
                        out.println("Неверный номер задачи.");
                        break;
                }
                break; // конец четвертого раздела

            default:
                out.println("Неверный номер раздела.");
                break;
        }
    }

    // ЗАДАЧА 1.1
    public double fraction(double x) {
        int y = (int) x;
        return x - (double) y;
    }

    // ЗАДАЧА 1.3
    public int charToNum(char x) {
        if (x >= '0' && x <= '9') {
            int y = x - '0';
            return y;
        } else {
            return -1;
        }
    }

    // ЗАДАЧА 1.5
    public boolean is2Digits(int x) {
        if ((x >= 10 && x <= 99) || (x >= -99 && x <= -10)) {
            return true;
        } else {
            return false;
        }
    }

    // ЗАДАЧА 1.7
    public boolean isInRange(int a, int b, int num) {
        if (a <= b) {
            return num >= a && num <= b;
        } else {
            return num >= b && num <= a;
        }
    }

    // ЗАДАЧА 1.9
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // ЗАДАЧА 2.1
    public int abs (int x) {
        if (x < 0) {
            return (-x); // Если x отрицательно, возвращаем его с обратным знаком
        } else {
            return x; // Если x неотрицательно, возвращаем его как есть
        }
    }

    // ЗАДАЧА 2.3
    public boolean is35 (int x) {
        if ((x % 3 == 0 && x % 5 != 0) || (x % 3 != 0 && x % 5 == 0)) {
            return true; // Делится нацело на 3 или 5, но не на оба
        } else {
            return false; // Делится нацело и на 3, и на 5
        }
    }

    // ЗАДАЧА 2.5
    public int max3 (int x, int y, int z) {
        int max = x; // Предположим, что x - максимальное

        if (y > max) {
            max = y; // Если y больше, то y - максимальное
        }

        if (z > max) {
            max = z; // Если z больше, то z - максимальное
        }

        return max; // Возвращаем максимальное значение
    }

    // ЗАДАЧА 2.7
    public int sum2 (int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) { // Проверяем, попадает ли сумма в диапазон
            return 20;
        } else {
            return sum; // Если сумма не в диапазоне, возвращаем ее
        }
    }

    // Задача 2.9
    public String day (int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    // ЗАДАЧА 3.1
    public String listNums (int x) {
        String result = "";

        for (int i = 0; i <= x; i++) {
            result += i;
            if (i < x) {
                result += " ";
            }
        }

        return result;
    }

    // ЗАДАЧА 3.3
    public String chet (int x) {
        String result = "";

        for (int i = 0; i <= x; i += 2) {
            result += i;
            if (i < x - 1) {
                result += " ";
            }
        }

        return result;
    }

    // ЗАДАЧА 3.5
    public int numLen (long x) {
        if (x == 0) {
            return 1; // Если x равно 0, длина равна 1
        }

        int length = 0;
        while (x != 0) {
            x /= 10; // Делим на 10, чтобы отбросить последнюю цифру
            length++; // Увеличиваем счетчик длины
        }

        return length;
    }

    // ЗАДАЧА 3.7
    public void square (int x) {
        for (int i = 0; i < x; i++) { // Строки
            for (int j = 0; j < x; j++) { // Столбцы
                System.out.print("*"); // Выводим символ '*'
            }
            System.out.println(); // Переход на новую строку после каждой строки
        }
    }

    // ЗАДАЧА 3.9
    public void rightTriangle (int x) {
        for (int i = 1; i <= x; i++) { // Строки
            for (int j = 1; j <= x - i; j++) { // Пробелы
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) { // Звездочки
                System.out.print("*");
            }
            System.out.println(); // Переход на новую строку
        }
    }

    // ЗАДАЧА 4.1
    public int findFirst (int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) { // Проходимся по массиву
            if (arr[i] == x) { // Если нашли x
                return i; // Возвращаем индекс
            }
        }
        return -1; // Если x не найден, возвращаем -1
    }

    // ЗАДАЧА 4.3
    public int maxAbs (int[] arr) {
        if (arr.length == 0) {
            return 0; // Если массив пустой, возвращаем 0
        }

        int maxAbs = arr[0]; // Начинаем с первого элемента
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxAbs)) {
                maxAbs = arr[i]; // Обновляем maxAbs, если нашли большее значение по модулю
            }
        }
        return maxAbs;
    }

    // ЗАДАЧА 4.5
    public int[] add (int[] arr, int[] ins, int pos){
        if (pos < 0 || pos > arr.length) {
            out.println("Неправильная позиция");
        }
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }

        return result;
    }

    // ЗАДАЧА 4.7
    public int[] reverseBack (int[] arr) {
        int[] reversed = new int[arr.length]; // Создаем новый массив для результата
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i]; // Копируем элементы задом наперед
        }
        return reversed; // Возвращаем новый массив
    }

    // ЗАДАЧА 4.9
    public int[] findAll (int[] arr, int x) {
        int count = 0; // Счетчик вхождений
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++; // Увеличиваем счетчик, если нашли x
            }
        }

        int[] result = new int[count]; // Создаем новый массив для индексов
        int index = 0; // Индекс в массиве результата
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index++] = i; // Добавляем индекс в массив результата
            }
        }

        return result; // Возвращаем массив индексов
    }
}