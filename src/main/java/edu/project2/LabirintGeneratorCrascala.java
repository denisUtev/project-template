package edu.project2;

public class LabirintGeneratorCrascala implements Generator{
    @Override
    public Maze generate(int width, int height) {
        Cell[][] maze = new Cell[height][width];

        

        return new Maze(width, height, maze);
        /*
        ########
        #...   #
        ###.   #
        #...   #
        ########
         */
    }
}
