package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("тест второго задания hw3")
    void task1Test() {
        assertThat(clusterize("()()()")).isEqualTo(new String[]{"()", "()", "()"});
        assertThat(clusterize("((()))")).isEqualTo(new String[]{"((()))"});
        assertThat(clusterize("((()))(())()()(()())")).isEqualTo(new String[]{"((()))", "(())", "()", "()", "(()())"});
        assertThat(clusterize("((())())(()(()()))")).isEqualTo(new String[]{"((())())", "(()(()()))"});
    }
}
