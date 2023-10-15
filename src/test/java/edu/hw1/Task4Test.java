package edu.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест четвертого задания")
    void task4Test() {
        AssertionsForClassTypes.assertThat(Task4.fixString("123456")).isEqualTo("214365");
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
        assertThat(Task4.fixString("badce")).isEqualTo("abcde");
    }
}
