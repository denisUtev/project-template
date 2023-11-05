package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на самое старое животное ниже k см")
    void testOldestAnimalBelowK() {
        int k = 50;
        Animal oldestAnimal = Task8.getHeviestAnimalBelowK(DataBaseAnimals.ANIMAL_LIST, k);

        boolean isOldest = true;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.height() < k && oldestAnimal.age() < a.age()) {
                isOldest = false;
                break;
            }
        }

        assertThat(isOldest).isEqualTo(true);
    }
}
