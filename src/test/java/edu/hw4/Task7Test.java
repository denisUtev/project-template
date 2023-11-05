package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на к-тое самое старое животное")
    void testOldAnimal() {
        int k = 3;
        Animal oldAnimal = Task7.getOldestAnimal(DataBaseAnimals.ANIMAL_LIST, k);

        int countOlderAnimals = 0;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.age() > oldAnimal.age()) {
                countOlderAnimals++;
            }
        }

        assertThat(countOlderAnimals).isEqualTo(k - 1);
    }
}
