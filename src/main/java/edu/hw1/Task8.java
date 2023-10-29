package edu.hw1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class Task8 {

    private Task8() {
    }

    private static final int BOARD_SIZE = 8;
    private static final int HORSE_NUMBER = 1;
    private static final int MAX_MOVING = 2;

    public static boolean knightBoardCapture(int[][] board) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[y][x] == HORSE_NUMBER) {
                    for (Point move : getMoves(new Point(x, y))) {
                        if (board[move.y][move.x] == HORSE_NUMBER) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static List<Point> getMoves(Point pos) {
        List<Point> moves = new ArrayList<>();
        for (int x = -MAX_MOVING; x <= MAX_MOVING; x++) {
            for (int y = -MAX_MOVING; y <= MAX_MOVING; y++) {
                Point newPos = new Point(pos.x + x, pos.y + y);
                if (Math.abs(x) != Math.abs(y) && x != 0 && y != 0 && isInBounds(newPos)) {
                    moves.add(newPos);
                }
            }
        }
        return moves;
    }

    private static boolean isInBounds(Point pos) {
        return pos.x >= 0 && pos.x < BOARD_SIZE && pos.y >= 0 && pos.y < BOARD_SIZE;
    }

}
