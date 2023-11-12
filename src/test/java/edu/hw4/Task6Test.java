package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест на Мапу с самыми тяжелыми животными каждого вида")
    void testMapOfHeaviestAnimals() {
        Map<Animal.Type, Animal> mapOfHeaviestAnimals = Task6.getMapOfHeaviestAnimals(DataBaseAnimals.ANIMAL_LIST);

        assertThat(mapOfHeaviestAnimals.get(Animal.Type.DOG).name()).isEqualTo("Hippo");
        assertThat(mapOfHeaviestAnimals.get(Animal.Type.CAT).name()).isEqualTo("cat1 t p");
        assertThat(mapOfHeaviestAnimals.get(Animal.Type.SPIDER).name()).isEqualTo("Socrat");
        assertThat(mapOfHeaviestAnimals.get(Animal.Type.BIRD).name()).isEqualTo("bird1");
        assertThat(mapOfHeaviestAnimals.get(Animal.Type.FISH).name()).isEqualTo("Shark");
    }
}
