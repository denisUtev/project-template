package edu.hw4;

import edu.hw4.Task1.*;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест сортировки по возрасту")
    void testSortingByAge() {
        List<Animal> animalList = Task1.getSortedByAgeListOfAnimals(DataBaseAnimals.ANIMAL_LIST);

        boolean isSorted = true;
        for(int i = 1; i < animalList.size(); i++) {
            if (animalList.get(i).age() < animalList.get(i - 1).age()) {
                isSorted = false;
                break;
            }
        }

        assertThat(isSorted).isEqualTo(true);
    }
}
