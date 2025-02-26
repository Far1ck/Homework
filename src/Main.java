import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int year = 1945;
        isLeapYear(year);
        appVersion(1, 2025);
        int deliveryDistance = 95;
        System.out.println("Потребуется дней для доставки: " + delivery(deliveryDistance));
    }

    // Задача 1
    public static void isLeapYear(int year) {
        if (year >= 1584 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            System.out.println(year + " год - високосный год");
        } else {
            System.out.println(year + " год - невисокосный год");
        }
    }

    // Задача 2
    public static void appVersion(int os, int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (os == 0 && deviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (os == 0 && deviceYear == currentYear) {
            System.out.println("Установите обычную версию приложения для iOS по ссылке");
        } else if (os == 1 && deviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (os == 1 && deviceYear == currentYear) {
            System.out.println("Установите обычную версию приложения для Android по ссылке");
        } else {
            System.out.println("Некорректно указаны ОС и год выпуска устройства!");
        }
    }

    // Задача 3
    public static int delivery(int distance) {
        int deliveryTime = 0;
        if (distance > 0 && distance <= 20) {
            deliveryTime++;
        } else if (distance > 20 && distance <= 60) {
            deliveryTime += 2;
        } else if (distance > 60 && distance <= 100) {
            deliveryTime += 3;
        }
        return deliveryTime;
    }
}

