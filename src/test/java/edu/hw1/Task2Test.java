package hw1;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест второго задания")
    void task2Test() {
        assertThat(Task2.countDigits(4666)).isEqualTo(4);
        assertThat(Task2.countDigits(544)).isEqualTo(3);
        assertThat(Task2.countDigits(0)).isEqualTo(1);
    }
}
