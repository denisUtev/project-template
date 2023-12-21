package edu.hw5;

import edu.hw5.Task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("тест 2020-10-10")
    void testPattern1() {
        Optional<LocalDate> date = Task3.parseDate("2020-10-10");
        assertThat(date.get()).isEqualTo("2020-10-10");
    }

    @Test
    @DisplayName("тест 2020-10-2")
    void testPattern1Without1number() {
        Optional<LocalDate> date = Task3.parseDate("2020-10-2");
        assertThat(date.get()).isEqualTo("2020-10-02");
    }

    @Test
    @DisplayName("тест 2020-10-2")
    void testPattern1Without2number() {
        Optional<LocalDate> date = Task3.parseDate("2020-8-2");
        assertThat(date.get()).isEqualTo("2020-08-02");
    }

    @Test
    @DisplayName("тест 1/3/1976")
    void testPattern2() {
        Optional<LocalDate> date = Task3.parseDate("1/3/1976");
        assertThat(date.get()).isEqualTo("1976-03-01");
    }

    @Test
    @DisplayName("тест 10/11/1976")
    void testPattern2WithTwoNumbers() {
        Optional<LocalDate> date = Task3.parseDate("10/11/1976");
        assertThat(date.get()).isEqualTo("1976-11-10");
    }

    @Test
    @DisplayName("тест: если ничего не подошло")
    void testNoPattern() {
        Optional<LocalDate> date = Task3.parseDate("10/11/19/76");
        assertThat(date).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("тест: tomorrow, today and yesterday")
    void testTomorrowTodayYesterday() {
        Optional<LocalDate> date = Task3.parseDate("tomorrow");
        assertThat(date).isEqualTo(Optional.of(LocalDate.now().plusDays(1)));

        Optional<LocalDate> date2 = Task3.parseDate("today");
        assertThat(date2).isEqualTo(Optional.of(LocalDate.now()));

        Optional<LocalDate> date3 = Task3.parseDate("yesterday");
        assertThat(date3).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
    }

    @Test
    @DisplayName("тест: n days ago")
    void testNDaysAgo() {
        Optional<LocalDate> date = Task3.parseDate("1 day ago");
        assertThat(date).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));

        Optional<LocalDate> date2 = Task3.parseDate("10 days ago");
        assertThat(date2).isEqualTo(Optional.of(LocalDate.now().minusDays(10)));
    }
}
