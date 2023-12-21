package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("тест нечетности длины")
    void testIsNotEvenNumbered() {
        assertThat(Task8.isNotEvenNumbered("11000")).isEqualTo(true);
        assertThat(Task8.isNotEvenNumbered("110000")).isEqualTo(false);
        assertThat(Task8.isNotEvenNumbered("11")).isEqualTo(false);
        assertThat(Task8.isNotEvenNumbered("1")).isEqualTo(true);
        assertThat(Task8.isNotEvenNumbered("")).isEqualTo(false);
    }

    @Test
    @DisplayName("тест нечетности длины")
    void testIsEvenNumberedOrNot() {
        assertThat(Task8.isEvenNumberedOrNot("01010")).isEqualTo(true);
        assertThat(Task8.isEvenNumberedOrNot("0111100")).isEqualTo(true);
        assertThat(Task8.isEvenNumberedOrNot("00011001")).isEqualTo(false);
        assertThat(Task8.isEvenNumberedOrNot("11010")).isEqualTo(false);
        assertThat(Task8.isEvenNumberedOrNot("111110")).isEqualTo(true);
        assertThat(Task8.isEvenNumberedOrNot("1001100")).isEqualTo(false);
        assertThat(Task8.isEvenNumberedOrNot("10101101")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест кратности трем количества нулей")
    void testIsCountZeroDivided3() {
        assertThat(Task8.isCountZeroDivided3("01010")).isEqualTo(true);
        assertThat(Task8.isCountZeroDivided3("0111100")).isEqualTo(true);
        assertThat(Task8.isCountZeroDivided3("00011001")).isEqualTo(false);
        assertThat(Task8.isCountZeroDivided3("11010")).isEqualTo(false);
        assertThat(Task8.isCountZeroDivided3("111110")).isEqualTo(false);
        assertThat(Task8.isCountZeroDivided3("1001100")).isEqualTo(false);
        assertThat(Task8.isCountZeroDivided3("10101101")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест кратности трем количества нулей")
    void testIsAllNotEvenNumberedIsOne() {
        assertThat(Task8.isAllNotEvenNumberedIsOne("01010")).isEqualTo(false);
        assertThat(Task8.isAllNotEvenNumberedIsOne("0111100")).isEqualTo(false);
        assertThat(Task8.isAllNotEvenNumberedIsOne("00011001")).isEqualTo(false);
        assertThat(Task8.isAllNotEvenNumberedIsOne("10111")).isEqualTo(true);
        assertThat(Task8.isAllNotEvenNumberedIsOne("111110")).isEqualTo(true);
        assertThat(Task8.isAllNotEvenNumberedIsOne("1001100")).isEqualTo(false);
        assertThat(Task8.isAllNotEvenNumberedIsOne("101010101")).isEqualTo(true);
    }
}
