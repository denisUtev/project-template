package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task14Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Есть ли в списке собака ростом более k см")
    void testIsHaveDogHighK() {
        boolean isHaveDogHigh60sm = Task14.isHaveDogHighK(DataBaseAnimals.ANIMAL_LIST, 60);

        assertThat(isHaveDogHigh60sm).isEqualTo(true);
    }
}
