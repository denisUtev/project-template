package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на самый популярный пол")
    void testMostPopularSex() {
        Animal.Sex animalWithLongestName = Task5.getMostPopularSex(DataBaseAnimals.ANIMAL_LIST);

        assertThat(animalWithLongestName).isEqualTo(Animal.Sex.M);
    }
}
