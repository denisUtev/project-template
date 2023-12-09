package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("тест вычисления факториала числа с помощью parallelStream")
    void testThreadSafety() {
        Long number = Task2.getFactorialByParallelStream(6);
        assertThat(number).isEqualTo(720);
    }
}
