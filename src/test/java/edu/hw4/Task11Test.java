package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task11Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на список животных, которые могут укусить и рост которых превышает 100 см")
    void testListBitingHighAnimals() {
        List<Animal> animalList = Task11.getListBitingHighAnimals(DataBaseAnimals.ANIMAL_LIST);

        boolean isRight = true;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.bites() && a.height() > 100 && !animalList.contains(a)) {
                isRight = false;
                break;
            }
        }

        assertThat(isRight).isEqualTo(true);
    }
}
