package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    @DisplayName("тест первой регулярки")
    void testValid1() {
        assertThat(Task7.isValid1("11000")).isEqualTo(true);
        assertThat(Task7.isValid1("111000")).isEqualTo(false);
        assertThat(Task7.isValid1("110")).isEqualTo(true);
        assertThat(Task7.isValid1("000")).isEqualTo(true);
        assertThat(Task7.isValid1("001")).isEqualTo(false);
        assertThat(Task7.isValid1("00")).isEqualTo(false);
        assertThat(Task7.isValid1("0")).isEqualTo(false);
    }

    @Test
    @DisplayName("тест второй регулярки")
    void testValid2() {
        assertThat(Task7.isValid2("11000")).isEqualTo(false);
        assertThat(Task7.isValid2("110")).isEqualTo(false);
        assertThat(Task7.isValid2("000")).isEqualTo(true);
        assertThat(Task7.isValid2("001")).isEqualTo(false);
        assertThat(Task7.isValid2("00")).isEqualTo(true);
        assertThat(Task7.isValid2("0")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест третьей регулярки")
    void testValid3() {
        assertThat(Task7.isValid3("1")).isEqualTo(true);
        assertThat(Task7.isValid3("110")).isEqualTo(true);
        assertThat(Task7.isValid3("000")).isEqualTo(true);
        assertThat(Task7.isValid3("0011")).isEqualTo(false);
        assertThat(Task7.isValid3("")).isEqualTo(false);
        assertThat(Task7.isValid3("101111")).isEqualTo(false);
    }
}
