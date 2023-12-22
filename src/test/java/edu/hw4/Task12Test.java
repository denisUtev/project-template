package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task12Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: сколько в списке животных, вес которых превышает рост ")
    void testCountAnimalsWhereWeightMoreHeight() {
        int count = Task12.getCountAnimalsWhereWeightMoreHeight(DataBaseAnimals.ANIMAL_LIST);

        int realCount = 0;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.weight() > a.height()) {
                realCount++;
            }
        }

        assertThat(count).isEqualTo(realCount);
    }
}
