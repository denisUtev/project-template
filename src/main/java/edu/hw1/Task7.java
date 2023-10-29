package edu.hw1;

import java.util.ArrayList;
import java.util.List;

public final class Task7 {

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        List<Integer> bits = getBitsOfNumber(n);
        List<Integer> newBits = new ArrayList<>(bits.size());

        for (int i = 0; i < bits.size(); i++) {
            int index = (i - shift < 0) ? bits.size() - (shift - i) : i - shift;
            newBits.add(bits.get(index));
        }

        return getIntOfBits(newBits);
    }

    public static int rotateRight(int n, int shift) {
        List<Integer> bits = getBitsOfNumber(n);
        List<Integer> newBits = new ArrayList<>(bits.size());

        for (int i = 0; i < bits.size(); i++) {
            newBits.add(bits.get((i + shift) % bits.size()));
        }

        return getIntOfBits(newBits);
    }

    private static List<Integer> getBitsOfNumber(int n) {
        List<Integer> bits = new ArrayList<>();
        int num = 1;
        while (num <= n) {
            bits.add((n & num) / num);
            num *= 2;
        }
        return bits;
    }

    private static int getIntOfBits(List<Integer> bits) {
        int number = bits.get(0);
        for (int i = 1; i < bits.size(); i++) {
            number += i * bits.get(i) * 2;
        }
        return number;
    }

}
