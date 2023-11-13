package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("тест 2023 года")
    void test2023Year() {
        String fridays = Task2.get13Fridays(2023);
        assertThat(fridays).isEqualTo("[2023-01-13, 2023-10-13]");
    }

    @Test
    @DisplayName("тест 1925 года")
    void test1925Year() {
        String fridays = Task2.get13Fridays(1925);
        assertThat(fridays).isEqualTo("[1925-02-13, 1925-03-13, 1925-11-13]");
    }

    @Test
    @DisplayName("тест 2024 года")
    void test2024Year() {
        String fridays = Task2.get13Fridays(2024);
        assertThat(fridays).isEqualTo("[2024-09-13, 2024-12-13]");
    }

    @Test
    @DisplayName("тест следующей пятницы 13")
    void testNextFriday13() {
        String fridays = Task2.getNextFriday13(LocalDate.of(2024, 8, 1));
        assertThat(fridays).isEqualTo("2024-09-13");
    }

    @Test
    @DisplayName("тест следующей пятницы 13 (2)")
    void test2NextFriday13() {
        String fridays = Task2.getNextFriday13(LocalDate.of(1925, 2, 14));
        assertThat(fridays).isEqualTo("1925-03-13");
    }
}
