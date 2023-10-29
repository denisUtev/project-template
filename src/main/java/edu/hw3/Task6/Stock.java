package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String name, int price) implements Comparable{
    @Override
    public int compareTo(@NotNull Object o) {
        if (price > ((Stock) o).price) {
            return 1;
        }
        if (price < ((Stock) o).price) {
            return -1;
        }
        return 0;
    }
}
