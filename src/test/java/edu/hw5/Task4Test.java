package edu.hw5;

import edu.hw5.Task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("тест подходящих паролей")
    void testCorrectPasswords() {
        assertThat(Task4.isCorrectPassword("qwe~rty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qwe!rty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qwe@rty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("$qwerty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qwert^^y")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qw&erty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qw*e*rty")).isEqualTo(true);
        assertThat(Task4.isCorrectPassword("qw|erty")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест неправильных паролей")
    void testInCorrectPasswords() {
        assertThat(Task4.isCorrectPassword("qweQQQrty")).isEqualTo(false);
        assertThat(Task4.isCorrectPassword("qwe rty")).isEqualTo(false);
        assertThat(Task4.isCorrectPassword("qwerty")).isEqualTo(false);
    }
}
