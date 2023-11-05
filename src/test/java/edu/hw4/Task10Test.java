package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на список животных, возраст у которых не совпадает с количеством лап")
    void testListAnimalsWhereCountPawsNotEqualAge() {
        List<Animal> listAnimals = Task10.getListAnimalsWhereCountPawsNotEqualAge(DataBaseAnimals.ANIMAL_LIST);

        boolean isRight = true;
        for(Animal a : DataBaseAnimals.ANIMAL_LIST) {
            if (a.age() != a.paws() && !listAnimals.contains(a)) {
                isRight = false;
                break;
            }
        }

        assertThat(isRight).isEqualTo(true);
    }
}
