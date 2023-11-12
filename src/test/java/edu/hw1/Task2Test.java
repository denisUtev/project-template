package edu.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест второго задания")
    void task2Test() {
        AssertionsForClassTypes.assertThat(Task2.countDigits(4666)).isEqualTo(4);
        assertThat(Task2.countDigits(544)).isEqualTo(3);
        assertThat(Task2.countDigits(0)).isEqualTo(1);
        assertThat(Task2.countDigits(-314)).isEqualTo(3);
    }
}
