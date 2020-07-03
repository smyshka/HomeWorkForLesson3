package com.itacademy;

import java.util.Scanner;

public class QuadraticEquation {
    /**
     * Написать программу, вычисляющую корни квадратного уравнения
     * вида ax ² + bx + c = 0, где a, b и c - вводимые пользователем из консоли
     * данные.
     *     Учитывать только реальные корни (в случае отрицательного
     * дискриминанта выводить сообщение пользователю).
     *     При решении создать и использовать следующие вынесенные
     * функции:
     *     - функция isPositive, определяющая, является ли число
     * положительным
     *     - функция isZero, определяющая, является ли число нулём
     *     - функция discriminant, вычисляющая дискриминант
     */
    public static void main(String[] args) {

        double x, x1, x2;
        Scanner in = new Scanner(System.in);
        System.out.print("Для решения квадратного уравнения ax ² + bx + c = 0, ведите параметры a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        System.out.print("c = ");
        double c = in.nextDouble();

        double D = discriminant(a, b, c);
        if (a == 0) {
            System.out.println("'a' не может быть равно 0, введите другое значение");
        } else if (b == 0 && c == 0) {
            System.out.println("Уравнение имеет один корень: x = 0");
        } else if (isZero(D)) {
            x = -b / (2 * a);
            System.out.println("Уравнение имеет один корень: " + "x = " + x);
        } else if (isPositive(D)) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Уравнение имеет два корня:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            System.out.println("Уравнение не имеет действительных решений (дискриминант меньше нуля)");
        }
    }

    public static double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static boolean isPositive(double D) {
        return D > 0;
    }

    public static boolean isZero(double D) {
        return D == 0;
    }
}

