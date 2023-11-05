package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DataBaseAnimals {

    public static final List<Animal> ANIMAL_LIST = new ArrayList<>(
        Arrays.asList(
            new Animal("Graph Mauser", Animal.Type.CAT, Animal.Sex.M, 2, 30, 2, true),
            new Animal("cat1 t p", Animal.Type.CAT, Animal.Sex.M, 8, 50, 5, false),
            new Animal("bird1", Animal.Type.BIRD, Animal.Sex.F, 10, 10, 1, true),
            new Animal("Toddi", Animal.Type.DOG, Animal.Sex.M, 5, 66, 6, true),
            new Animal("Mr. Snoopy", Animal.Type.DOG, Animal.Sex.M, 4, 59, 5, true),
            new Animal("Socrat", Animal.Type.SPIDER, Animal.Sex.M, 18, 25, 1, false),
            new Animal("Newton", Animal.Type.FISH, Animal.Sex.M, 3, 15, 1, false),
            new Animal("Shark", Animal.Type.FISH, Animal.Sex.F, 7, 180, 15, true),
            new Animal("Hippo", Animal.Type.DOG, Animal.Sex.M, 12, 70, 8, true)
        ));

    private DataBaseAnimals() {

    }
}
