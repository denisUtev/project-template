package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("тест одного сеанса")
    void testSingleSession() {
        Duration duration = Task1.getAverageTimeSession(Arrays.asList("2022-03-12, 20:20 - 2022-03-12, 23:50"));
        assertThat(duration.toMinutes()).isEqualTo(210);
    }

    @Test
    @DisplayName("тест двух сеансов, один из которых со сменой дня")
    void testTwoSessions() {
        Duration duration = Task1.getAverageTimeSession(Arrays.asList
            ("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"));
        assertThat(duration.toMinutes()).isEqualTo(220);
    }
}
