package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест подсчета количеств животных каждого вида")
    void testCountOfTypeAnimal() {
        Map<Animal.Type, Integer> countTypeAnimal = Task3.getMapOfCountTypeAnimal(DataBaseAnimals.ANIMAL_LIST);

        assertThat(countTypeAnimal.get(Animal.Type.DOG)).isEqualTo(3);
        assertThat(countTypeAnimal.get(Animal.Type.CAT)).isEqualTo(2);
        assertThat(countTypeAnimal.get(Animal.Type.FISH)).isEqualTo(2);
        assertThat(countTypeAnimal.get(Animal.Type.BIRD)).isEqualTo(1);
        assertThat(countTypeAnimal.get(Animal.Type.SPIDER)).isEqualTo(1);
    }
}
