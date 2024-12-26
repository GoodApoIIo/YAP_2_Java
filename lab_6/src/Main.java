import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-3): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                /*A a = Cache.cache(new A("first"));
                System.out.println(a.cacheTest());

                a.stringField = "second";
                System.out.println(a.cacheTest());

                System.out.println(a.cacheTest());*/
                break;
            case 2:
                AnnotationTest test = new AnnotationTest();

                // 1. @Invoke для метода
                System.out.println("\n--- @Invoke ---");
                Method invokeMethod = test.getClass().getMethod("myMethod");
                if (invokeMethod.isAnnotationPresent(MyAnnotations.Invoke.class)) {
                    System.out.println("Метод 'myMethod' аннотирован @Invoke");
                }

                // 2. @Default для класса
                System.out.println("\n--- @Default для класса ---");
                Class<?> defaultClass = test.new MyDefaultClass().getClass();
                if (defaultClass.isAnnotationPresent(MyAnnotations.Default.class)) {
                    MyAnnotations.Default defaultAnnotation = defaultClass.getAnnotation(MyAnnotations.Default.class);
                    System.out.println("Класс 'MyDefaultClass' аннотирован @Default. Значение: " + defaultAnnotation.value().getSimpleName());
                }

                // 3. @ToString для класса
                System.out.println("\n--- @ToString для класса ---");
                Class<?> toStringClass = test.new MyToStringClass().getClass();
                if (toStringClass.isAnnotationPresent(MyAnnotations.ToString.class)) {
                    MyAnnotations.ToString toStringAnnotation = toStringClass.getAnnotation(MyAnnotations.ToString.class);
                    System.out.println("Класс 'MyToStringClass' аннотирован @ToString. Значение: " + toStringAnnotation.value());
                }

                // 4. @Validate для класса
                System.out.println("\n--- @Validate для класса ---");
                Class<?> validateClass = test.new MyValidateClass().getClass();
                if (validateClass.isAnnotationPresent(MyAnnotations.Validate.class)) {
                    MyAnnotations.Validate validateAnnotation = validateClass.getAnnotation(MyAnnotations.Validate.class);
                    System.out.print("Класс 'MyValidateClass' аннотирован @Validate. Значения: [");
                    for (Class<?> clazz : validateAnnotation.value()) {
                        System.out.print(clazz.getSimpleName() + ", ");
                    }
                    System.out.println("]");
                }

                // 5. @Two
                System.out.println("\n--- @Two ---");
                Class<?> twoClass = test.new MyTwoClass().getClass();
                if (twoClass.isAnnotationPresent(MyAnnotations.Two.class)) {
                    MyAnnotations.Two twoAnnotation = twoClass.getAnnotation(MyAnnotations.Two.class);
                    System.out.println("Класс 'MyTwoClass' аннотирован @Two. first: " + twoAnnotation.first() + ", second: " + twoAnnotation.second());
                }

                // 6. @Cache
                System.out.println("\n--- @Cache с value ---");
                Class<?> cacheClass = test.new MyCacheClass().getClass();
                if (cacheClass.isAnnotationPresent(MyAnnotations.Cache.class)) {
                    MyAnnotations.Cache cacheAnnotation = cacheClass.getAnnotation(MyAnnotations.Cache.class);
                    System.out.print("Класс 'MyCacheClass' аннотирован @Cache. Значения: [");
                    for (String item : cacheAnnotation.value()) {
                        System.out.print(item + ", ");
                    }
                    System.out.println("]");
                }

                break;
            case 3:
                break;
            default:
                System.out.println("Неверный номер задания");
        }
    }
}