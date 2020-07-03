package com.itacademy;

import java.util.Scanner;

/**
 * Имеются три числа - день, месяц и год, вводимые пользователем с
 * консоли.
 *     Вывести дату следующего дня в формате &quot;День.Месяц.Год&quot;.
 *     Учесть переход на следующий месяц, а также следующий год.
 *     Форматирование строки &quot;День.Месяц.Год&quot; вынести в отдельную
 * функцию.
 * <p>
 * Год считается високосным, если он делится без остатка на 4. Однако, если
 * год также делится на 100, то этот год не високосный, за исключением годов,
 * делящихся на 400.
 */

public class NextData {
    public static void main(String[] args) {

        Scanner date = new Scanner(System.in);
        System.out.print("Введите дату: День ");
        int day = date.nextInt();
        System.out.print("Месяц ");
        int month = date.nextInt();
        System.out.print("Год ");
        int year = date.nextInt();

        if (day <= 0 || month <= 0 || year <= 0) {
            System.out.println("Такой даты не существует, проверьте и введите еще раз");
        } else if ((day == 29 && month == 2) && isYearLeap(year)) {
            day = 1;
            month = 3;
            newDate(day, month, year);
        } else if ((day < 29 && month == 2) && isYearLeap(year)) {
            day++;
            newDate(day, month, year);
        } else if ((day == 28 && month == 2) && !(isYearLeap(year))) {
            day = 1;
            month = 3;
            newDate(day, month, year);
        } else if ((day < 28 && month == 2) && !(isYearLeap(year))) {
            day++;
            newDate(day, month, year);
        } else if ((day == 30 && isMonthThirtyDays(month))
                || (day == 31 && isMonthThirtyOneDays(month))) {
            day = 1;
            month++;
            newDate(day, month, year);
        } else if ((day < 30 && isMonthThirtyDays(month))
                || (day < 31 && (isMonthThirtyOneDays(month) || month == 12))) {
            day++;
            newDate(day, month, year);
        } else if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;
            newDate(day, month, year);
        } else {
            System.out.println("Такой даты не существует, проверьте и введите еще раз");
        }

    }

    public static void newDate(int day, int month, int year) {
        System.out.println(day + "." + month + "." + year);
    }

    public static boolean isYearLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isMonthThirtyDays(int month) {
        return (month == 4 || month == 6 || month == 9 || month == 11);
    }

    public static boolean isMonthThirtyOneDays(int month) {
        return (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10);
    }

}


