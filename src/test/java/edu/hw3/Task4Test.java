package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.clusterize;
import static edu.hw3.Task4.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("тест четвертого задания hw3")
    void task4Test() {
        assertThat(convertToRoman(2)).isEqualTo("II");
        assertThat(convertToRoman(12)).isEqualTo("XII");
        assertThat(convertToRoman(16)).isEqualTo("XVI");
        assertThat(convertToRoman(16)).isEqualTo("XVI");
        assertThat(convertToRoman(1123)).isEqualTo("MCXXIII");
        assertThat(convertToRoman(1934)).isEqualTo("MCMXXXIV");
    }
}
