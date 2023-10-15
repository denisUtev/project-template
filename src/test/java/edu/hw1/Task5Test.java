package hw1;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест пятого задания")
    void task5Test() {
        assertThat(Task5.isPalindromeDescendant(11211230)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(13001120)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(23336014)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(11)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(1234)).isEqualTo(false);
        assertThat(Task5.isPalindromeDescendant(1010)).isEqualTo(true);
    }
}
