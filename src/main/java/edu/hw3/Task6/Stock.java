package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String name, int price) implements Comparable {
    @Override
    public int compareTo(@NotNull Object o) {
        return Integer.compare(price, ((Stock) o).price);
    }
}
