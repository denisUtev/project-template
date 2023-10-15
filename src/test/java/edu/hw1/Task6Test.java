package hw1;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест шестого задания")
    void task6Test() {
        assertThat(Task6.countK(3524)).isEqualTo(3);
        assertThat(Task6.countK(6621)).isEqualTo(5);
        assertThat(Task6.countK(6554)).isEqualTo(4);
        assertThat(Task6.countK(1234)).isEqualTo(3);
    }
}
