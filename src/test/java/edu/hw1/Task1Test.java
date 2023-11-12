package edu.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест первого задания")
    void task1Test() {
        AssertionsForClassTypes.assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60);
        assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836);
        assertThat(Task1.minutesToSeconds("10:60")).isEqualTo(-1);
    }
}
