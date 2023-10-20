package edu.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест седьмого задания")
    void task7Test() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
    }
}
