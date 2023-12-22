package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на подсчет количества лап всех животных")
    void testCountPaws() {
        int countPaws = Task9.getCountOfPawsAnimals(DataBaseAnimals.ANIMAL_LIST);

        int realCount = 0;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            realCount += a.paws();
        }

        assertThat(countPaws).isEqualTo(realCount);
    }
}
