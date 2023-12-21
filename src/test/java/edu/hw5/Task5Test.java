package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("тест правильных номерных знаков")
    void testCorrectPasswords() {
        assertThat(Task5.isValidNumberMark("А123ВЕ777")).isEqualTo(true);
        assertThat(Task5.isValidNumberMark("О777ОО177")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест неверных номерных знаков")
    void testInCorrectPasswords() {
        assertThat(Task5.isValidNumberMark("123АВЕ777")).isEqualTo(false);
        assertThat(Task5.isValidNumberMark("А123ВГ77")).isEqualTo(false);
        assertThat(Task5.isValidNumberMark("А123ВЕ7777")).isEqualTo(false);
    }
}
