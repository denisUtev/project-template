package edu.hw7;

import edu.hw7.Task4.MultyThreadedVersion;
import edu.hw7.Task4.SingleThreadedVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("тест вычисления числа Пи с 10 миллионами испытаний")
    void testCalculatingPI1() {
        long startTime = System.currentTimeMillis();
        double myPIWithSingleThread = SingleThreadedVersion.getPI(10_000_000);
        long endTime = System.currentTimeMillis();
        long timeForSingleThread = endTime - startTime;

        long timeForMultyThread = 0;
        double myPIWithMultiThread = 0;
        int countTests = 50;
        for (int i = 0; i < countTests; i++) {
            startTime = System.currentTimeMillis();
            myPIWithMultiThread = MultyThreadedVersion.getPI(10_000_000, 6);
            endTime = System.currentTimeMillis();
            timeForMultyThread += endTime - startTime;
        }
        timeForMultyThread /= countTests;

        System.out.println("Среднее время ускорения решения в зависимости от количества потоков для 10 миллионов итераций:");
        System.out.println((double) timeForSingleThread / timeForMultyThread);
        System.out.println("Уровень погрешности для 10 миллионов итераций:");
        System.out.println(Math.PI / myPIWithMultiThread);
        System.out.println("______________________________________________");
    }

    @Test
    @DisplayName("тест вычисления числа Пи с 100 миллионами испытаний")
    void testCalculatingPI2() {
        long startTime = System.currentTimeMillis();
        double myPIWithSingleThread = SingleThreadedVersion.getPI(100_000_000);
        long endTime = System.currentTimeMillis();
        long timeForSingleThread = endTime - startTime;

        long timeForMultyThread = 0;
        double myPIWithMultiThread = 0;
        int countTests = 10;
        for (int i = 0; i < countTests; i++) {
            startTime = System.currentTimeMillis();
            myPIWithMultiThread = MultyThreadedVersion.getPI(100_000_000, 6);
            endTime = System.currentTimeMillis();
            timeForMultyThread += endTime - startTime;
        }
        timeForMultyThread /= countTests;

        System.out.println("Среднее время ускорения решения в зависимости от количества потоков для 100 миллионов итераций:");
        System.out.println((double) timeForSingleThread / timeForMultyThread);
        System.out.println("Уровень погрешности для 100 миллионов итераций:");
        System.out.println(Math.PI / myPIWithMultiThread);
        System.out.println("______________________________________________");
    }

    @Test
    @DisplayName("тест вычисления числа Пи с 1 миллиардом испытаний")
    void testCalculatingPI3() {
        long startTime = System.currentTimeMillis();
        double myPIWithSingleThread = SingleThreadedVersion.getPI(1_000_000_000);
        long endTime = System.currentTimeMillis();
        long timeForSingleThread = endTime - startTime;

        long timeForMultyThread = 0;
        double myPIWithMultiThread = 0;
        int countTests = 10;
        for (int i = 0; i < countTests; i++) {
            startTime = System.currentTimeMillis();
            myPIWithMultiThread = MultyThreadedVersion.getPI(1_000_000_000, 6);
            endTime = System.currentTimeMillis();
            timeForMultyThread += endTime - startTime;
        }
        timeForMultyThread /= countTests;

        System.out.println("Среднее время ускорения решения в зависимости от количества потоков для 1 миллиарда итераций:");
        System.out.println((double) timeForSingleThread / timeForMultyThread);
        System.out.println("Уровень погрешности для 1 миллиарда итераций:");
        System.out.println(Math.PI / myPIWithMultiThread);
        System.out.println("______________________________________________");
    }
}
