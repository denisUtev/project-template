package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест: Список животных, отсортированный по виду, затем по полу, затем по имени")
    void testSortedAnimalsByTypeSexName() {
        List<Animal> sortedListAnimals = Task16.getSortedAnimalsByTypeSexName(DataBaseAnimals.ANIMAL_LIST);
        sortedListAnimals.forEach(System.out::println);
        
        boolean isSorted = true;

        for (int i = 1; i < sortedListAnimals.size(); i++) {
            if (sortedListAnimals.get(i).type().ordinal() > sortedListAnimals.get(i - 1).type().ordinal()) {
                if (sortedListAnimals.get(i).sex().ordinal() > sortedListAnimals.get(i - 1).sex().ordinal()) {
                    if (sortedListAnimals.get(i).name().compareTo(sortedListAnimals.get(i - 1).name()) < 0) {
                        isSorted = false;
                        break;
                    }
                } else {
                    isSorted = false;
                    break;
                }
            } else {
                isSorted = false;
                break;
            }
        }

        assertThat(isSorted).isEqualTo(true);
    }
}
