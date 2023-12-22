package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Кусаются ли пауки чаще собак на обычных данных")
    void testIsSpidersBiteMoreThenDogs() {
        boolean isSpidersBitesMoreThenDogs = Task17.isSpidersBiteMoreThenDogs(DataBaseAnimals.ANIMAL_LIST);

        assertThat(isSpidersBitesMoreThenDogs).isEqualTo(false);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Нет данных о собаках")
    void testBitesWhenNoDogs() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 30, 2, true),
                new Animal("spider2", Animal.Type.SPIDER, Animal.Sex.M, 2, 30, 2, false)
            ));
        boolean isSpidersBitesMoreThenDogs = Task17.isSpidersBiteMoreThenDogs(listAnimals);

        assertThat(isSpidersBitesMoreThenDogs).isEqualTo(false);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Одинаково часто")
    void testEqualBites() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 30, 2, true),
                new Animal("dog1", Animal.Type.DOG, Animal.Sex.M, 2, 30, 2, true)
            ));
        boolean isSpidersBitesMoreThenDogs = Task17.isSpidersBiteMoreThenDogs(listAnimals);

        assertThat(isSpidersBitesMoreThenDogs).isEqualTo(false);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Пауки чаще, но их меньше")
    void testMoreSpidersBites() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 30, 2, true),
                new Animal("dog1", Animal.Type.DOG, Animal.Sex.M, 2, 30, 2, true),
                new Animal("dog2", Animal.Type.DOG, Animal.Sex.M, 2, 30, 2, false)
            ));
        boolean isSpidersBitesMoreThenDogs = Task17.isSpidersBiteMoreThenDogs(listAnimals);

        assertThat(isSpidersBitesMoreThenDogs).isEqualTo(false);
    }
}
