package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на животное с самым большим именем")
    void testAnimalWithLongestName() {
        Animal animalWithLongestName = Task4.getAnimalWithLongestName(DataBaseAnimals.ANIMAL_LIST);

        boolean isLongest = true;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (animalWithLongestName.name().length() < a.name().length()) {
                isLongest = false;
                break;
            }
        }

        assertThat(isLongest).isEqualTo(true);
    }
}
