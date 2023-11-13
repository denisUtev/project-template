package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class Task1 {

    private Task1() {

    }

    public static Duration getAverageTimeSession(Collection<String> sessions) {
        Duration sumPeriods = Duration.ZERO;
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        for (var session : sessions) {
            var times = Arrays.stream(session.split(" - "))
                .map(a -> LocalDateTime.parse(a, formatter)).toList();
            sumPeriods = sumPeriods.plus(Duration.between(times.get(0), times.get(1)));
        }

        return sumPeriods.dividedBy(sessions.size());
    }
}
