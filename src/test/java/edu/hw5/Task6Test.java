package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("тест правильных простых подстрок")
    void testCorrectSimpleSubstring() {
        assertThat(Task6.isSubstring("achfdbaabgabcaabg", "abc")).isEqualTo(true);
        assertThat(Task6.isSubstring("denis utev", "utev")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест неправильных простых подстрок")
    void testInCorrectSimpleSubstring() {
        assertThat(Task6.isSubstring("achfdbaabgabcaabg", "fda")).isEqualTo(false);
        assertThat(Task6.isSubstring("denis utev", "ytev")).isEqualTo(false);
    }

    @Test
    @DisplayName("тест правильных подстрок, использующих регулярки")
    void testCorrectSubstringWithRegex() {
        assertThat(Task6.isSubstring("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$", "[А-Я]")).isEqualTo(true);
        assertThat(Task6.isSubstring("denis{3}.*$", ".*")).isEqualTo(true);
    }

    @Test
    @DisplayName("тест неверных подстрок, использующих регулярки")
    void testInCorrectSubstringWithRegex() {
        assertThat(Task6.isSubstring("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$", "[А-{4}]")).isEqualTo(false);
        assertThat(Task6.isSubstring("denis{3}.*$", "*.$")).isEqualTo(false);
    }
}
