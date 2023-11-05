package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int width, int height, Cell[][] grid) {
        this.width = width;
        this.height = height;
        this.grid = grid;
    }
}
