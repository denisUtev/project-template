package edu.hw4;

import edu.hw4.Task19.Task19;
import edu.hw4.Task19.ValidationError;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Нет ошибок")
    void testNoErrors() {
        Map<String, Set<ValidationError>> mapErrors = Task19.getMapValidationErrors(DataBaseAnimals.ANIMAL_LIST);

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
        Map<String, Set<ValidationError>> mapErrors = Task19.getMapValidationErrors(listAnimals);

        assertThat(mapErrors.get("fish1").size()).isEqualTo(1);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Отрицательный вес и рост")
    void testNegativeWeightAndHeight() {
        var listAnimals = new ArrayList<>(
            Arrays.asList(
                new Animal("fish1", Animal.Type.FISH, Animal.Sex.M, 3, -30, -10, true),
                new Animal("fish2", Animal.Type.FISH, Animal.Sex.M, 2, 30, -30, false)
            ));
        Map<String, Set<ValidationError>> mapErrors = Task19.getMapValidationErrors(listAnimals);

        assertThat(mapErrors.get("fish1").size()).isEqualTo(2);
        assertThat(mapErrors.get("fish2").size()).isEqualTo(1);
    }
}
