package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {


    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Task2.Rectangle()),
            Arguments.of(new Task2.Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    @DisplayName("Тест второго задания hw2")
    void task2Test(Task2.Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);
        assertThat(rect.area()).isEqualTo(200.0);
    }
}
