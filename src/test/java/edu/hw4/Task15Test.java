package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Найти суммарный вес животных каждого вида, которым от k до l лет")
    void testMapSumWeightOfTypeAnimalsFromKToLYears() {
        Map<Animal.Type, Integer> animalsWeight = Task15.getMapSumWeightOfTypeAnimalsFromKToLYears(DataBaseAnimals.ANIMAL_LIST, 2, 9);

        assertThat(animalsWeight.get(Animal.Type.DOG)).isEqualTo(11);
        assertThat(animalsWeight.get(Animal.Type.SPIDER)).isEqualTo(0);
        assertThat(animalsWeight.get(Animal.Type.CAT)).isEqualTo(7);
        assertThat(animalsWeight.get(Animal.Type.FISH)).isEqualTo(16);
        assertThat(animalsWeight.get(Animal.Type.BIRD)).isEqualTo(0);
    }
}
