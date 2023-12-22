package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Нет ошибок")
    void testNoErrors() {
        Map<String, String> mapErrors = Task20.getMapErrors(DataBaseAnimals.ANIMAL_LIST);

        assertThat(mapErrors.isEmpty()).isEqualTo(true);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Отрицательный возраст")
    void testNegativeAge() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("fish1", Animal.Type.FISH, Animal.Sex.M, -13, 30, 10, true),
                new Animal("fish2", Animal.Type.FISH, Animal.Sex.M, 2, 30, 30, false)
            ));
        Map<String, String> mapErrors = Task20.getMapErrors(listAnimals);

        assertThat(mapErrors.get("fish1")).isEqualTo("age");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Отрицательный вес и рост")
    void testNegativeWeightAndHeight() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("fish1", Animal.Type.FISH, Animal.Sex.M, 3, -30, -10, true),
                new Animal("fish2", Animal.Type.FISH, Animal.Sex.M, 2, 30, -30, false)
            ));
        Map<String, String> mapErrors = Task20.getMapErrors(listAnimals);

        assertThat(mapErrors.get("fish1")).contains("height");
        assertThat(mapErrors.get("fish1")).contains("weight");
        assertThat(mapErrors.get("fish2")).contains("weight");
    }
}
