package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Task2 {

    private Task2() {

    }

    public static final int NUMBER_OF_DAY = 13;

    public static String get13Fridays(int year) {
        List<LocalDate> fridays13 = new ArrayList<>();
        LocalDate date = LocalDate.of(year, Month.JANUARY, 1);
        while (date.getYear() == year) {
            date = date.plusDays(1);
            if (date.getDayOfMonth() == NUMBER_OF_DAY && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays13.add(date);
            }
        }

        return "[" + fridays13.stream().map(LocalDate::toString).collect(Collectors.joining(", ")) + "]";
    }

    public static String getNextFriday13(LocalDate date) {
        LocalDate nextDate = date;

        while (nextDate.getDayOfMonth() != NUMBER_OF_DAY) {
            nextDate = nextDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return nextDate.toString();
    }
}
