package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест сортировки по весу")
    void testSortingByWeight() {
        List<Animal> animalList = Task2.getListOfHeaviestAnimals(DataBaseAnimals.ANIMAL_LIST, 4);

        boolean isSorted = true;
        for(int i = 1; i < animalList.size(); i++) {
            if (animalList.get(i).weight() > animalList.get(i - 1).weight()) {
                isSorted = false;
                break;
            }
        }

        assertThat(isSorted).isEqualTo(true);
        assertThat(animalList.size()).isEqualTo(4);
    }
}
