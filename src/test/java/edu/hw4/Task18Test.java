package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Найти самую тяжелую рыбку в одном списке")
    void testHeviestFishInSingleList() {
        Animal theHeviestFish = Task18.getHeviestFIsh(DataBaseAnimals.ANIMAL_LIST);

        assertThat(theHeviestFish.name()).isEqualTo("Shark");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Найти самую тяжелую рыбку в двух списках")
    void testHeviestFishInTwoLists() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("fish1", Animal.Type.FISH, Animal.Sex.M, 2, 30, 10, true),
                new Animal("fish2", Animal.Type.FISH, Animal.Sex.M, 2, 30, 30, false)
            ));
        Animal theHeviestFish = Task18.getHeviestFIsh(DataBaseAnimals.ANIMAL_LIST, listAnimals);

        assertThat(theHeviestFish.name()).isEqualTo("fish2");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Нет рыб")
    void testNoFishInLists() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("dog1", Animal.Type.DOG, Animal.Sex.M, 2, 30, 10, true),
                new Animal("dog2", Animal.Type.DOG, Animal.Sex.M, 2, 30, 30, false)
            ));
        Animal theHeviestFish = Task18.getHeviestFIsh(listAnimals);

        assertThat(theHeviestFish).isEqualTo(null);
    }
}
