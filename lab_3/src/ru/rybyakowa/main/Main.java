package ru.rybyakowa.main;

import ru.rybyakowa.city.City;
import ru.rybyakowa.city.TwoWayCity;
import ru.rybyakowa.city.Route;

import ru.rybyakowa.bird.Bird;
import ru.rybyakowa.bird.Cuckoo;
import ru.rybyakowa.bird.Parrot;
import ru.rybyakowa.bird.Sparrow;

import ru.rybyakowa.geometry.Point3D;

import ru.rybyakowa.calc.PowerCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ru.rybyakowa.calc.PowerCalculator.calculatePower;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-8): ");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                Map<String, City> cities = new HashMap<>();

                System.out.println("Введите количество городов:");
                int numCities = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numCities; i++) {
                    System.out.println("Введите название города:");
                    String cityName = scanner.nextLine();
                    cities.put(cityName, new City(cityName));
                }

                System.out.println("Введите количество дорог:");
                int numRoads = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numRoads; i++) {
                    System.out.println("Введите название города-отправления, города-назначения и стоимость:");
                    String fromCityName = scanner.next();
                    String toCityName = scanner.next();
                    int cost = scanner.nextInt();
                    scanner.nextLine();

                    City fromCity = cities.get(fromCityName);
                    City toCity = cities.get(toCityName);

                    if (fromCity == null || toCity == null) {
                        System.out.println("Ошибка: город не найден.");
                        i--;
                        continue;
                    }

                    try {
                        fromCity.addRoute(toCity, cost);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        i--;
                    }
                }

                for (City city : cities.values()) {
                    System.out.println(city);
                }

                System.out.println("Введите количество удалений маршрутов:");
                int numRemovals = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numRemovals; i++) {
                    System.out.println("Введите название города-отправления и города-назначения для удаления маршрута:");
                    String fromCityName = scanner.next();
                    String toCityName = scanner.next();
                    scanner.nextLine();

                    City fromCity = cities.get(fromCityName);
                    City toCity = cities.get(toCityName);

                    if (fromCity == null || toCity == null) {
                        System.out.println("Ошибка: город не найден.");
                        i--;
                        continue;
                    }

                    fromCity.removeRoute(toCity);
                }

                for (City city : cities.values()) {
                    System.out.println(city);
                }

                break;

            case 2:
                Map<String, City> citiesByName = new HashMap<>();

                System.out.print("Введите количество городов: ");
                int numCitie = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numCitie; i++) {
                    System.out.print("Введите название города " + (i + 1) + ": ");
                    String cityName = scanner.nextLine();
                    City city = new City(cityName);
                    citiesByName.put(cityName, city);
                }

                System.out.print("Введите количество маршрутов между городами: ");
                int numRoutes = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numRoutes; i++) {
                    System.out.print("Введите название города отправления, города назначения и стоимость: ");
                    String fromCityName = scanner.next();
                    String toCityName = scanner.next();
                    int cost = scanner.nextInt();
                    scanner.nextLine();

                    City fromCity = citiesByName.get(fromCityName);
                    City toCity = citiesByName.get(toCityName);

                    if (fromCity == null || toCity == null) {
                        System.out.println("Ошибка: город не найден.");
                        i--;
                        continue;
                    }
                    fromCity.addRoute(toCity, cost);
                }

                System.out.print("Введите название города отправления и города назначения для маршрута: ");
                String startCityName = scanner.next();
                String endCityName = scanner.next();

                City startCity = citiesByName.get(startCityName);
                City endCity = citiesByName.get(endCityName);

                if (startCity == null || endCity == null) {
                    System.out.println("Ошибка: город не найден.");
                } else {
                    Route route = new Route(startCity, endCity);
                    System.out.println("Маршрут: " + route);
                }

                scanner.close();
                break;
            case 3:
                System.out.print("Введите номер подзадания (3 или 5): ");
                int n1 = scanner.nextInt();

                switch (n1) {

                    case 3:
                        Map<String, City> cities_By_Name = new HashMap<>();

                        System.out.print("Введите количество городов: ");
                        int num_Cities = readInt(scanner);
                        scanner.nextLine();

                        for (int i = 0; i < num_Cities; i++) {
                            System.out.print("Введите название города " + (i + 1) + ": ");
                            String cityName = scanner.nextLine();
                            City city = new TwoWayCity(cityName);
                            cities_By_Name.put(cityName, city);
                        }

                        System.out.print("Введите количество маршрутов между городами: ");
                        int num_Routes = readInt(scanner);

                        for (int i = 0; i < num_Routes; i++) {
                            System.out.print("Введите название города отправления, города назначения и стоимость: ");
                            String fromCityName = scanner.next();
                            String toCityName = scanner.next();
                            int cost = readPositiveInt(scanner);
                            scanner.nextLine();

                            City fromCity = cities_By_Name.get(fromCityName);
                            City toCity = cities_By_Name.get(toCityName);

                            if (fromCity == null || toCity == null) {
                                System.out.println("Ошибка: Город не найден.");
                                i--;
                                continue;
                            }
                            try {
                                fromCity.addRoute(toCity, cost);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Ошибка: " + e.getMessage());
                                i--;
                                continue;
                            }
                        }

                        System.out.println("\nИнформация о городах и маршрутах:");
                        for (City city : cities_By_Name.values()) {
                            System.out.println(city);
                        }

                        scanner.close();
                        break;

                    case 5:
                        System.out.print("Введите количество точек: ");

                        int num = scanner.nextInt();

                        Point3D[] points = new Point3D[num];

                        System.out.println("Введите координаты этих точек (x y z):");

                        for (int i = 0; i < num; i++) {
                            System.out.println("Точка " + (i + 1) + ":");
                            System.out.print("x: ");
                            double x = scanner.nextDouble();
                            System.out.print("y: ");
                            double y = scanner.nextDouble();
                            System.out.print("z: ");
                            double z = scanner.nextDouble();
                            points[i] = new Point3D(x, y, z);
                        }

                        scanner.close();

                        System.out.println("\nТекстовое представление точек:");
                        for (Point3D point : points) {
                            System.out.println(point);
                        }
                        break;

                    default: System.out.println("Некорректный номер подзадачи.");
                }
                break;
            case 4:
                Bird sparrow = new Sparrow("Воробей");
                Bird cuckoo = new Cuckoo("Кукушка");
                Bird parrot = new Parrot("Попугай", "Попугай, попугай");

                sparrow.sing();
                cuckoo.sing();
                parrot.sing();
                break;
            default: System.out.println("Неверный номер задания.");
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Пожалуйста, введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int readPositiveInt(Scanner scanner) {
        int num;
        do {
            num = readInt(scanner);
            if (num <= 0) {
                System.out.println("Ошибка: Стоимость должна быть положительным числом.");
            }
        } while (num <= 0);
        return num;
    }
}