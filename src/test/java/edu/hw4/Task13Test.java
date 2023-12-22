package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на список животных, имена которых состоят из более чем двух слов")
    void testListAnimalsWhereNameMore2Words() {
        List<Animal> animalList = Task13.getListAnimalsWhereNameMore2Words(DataBaseAnimals.ANIMAL_LIST);

        boolean isRight = true;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.name().split(" ").length > 2 && !animalList.contains(a)) {
                isRight = false;
                break;
            }
        }

        assertThat(isRight).isEqualTo(true);
    }
}
