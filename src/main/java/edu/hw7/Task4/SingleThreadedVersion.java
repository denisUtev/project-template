package edu.hw7.Task4;

import java.util.Random;

public final class SingleThreadedVersion {

    private SingleThreadedVersion() {

    }

    private static final double CENTER_POS = 0.5d;
    private static final double RADIUS = 0.5d;

    @SuppressWarnings("MagicNumber")
    public static double getPI(long iterators) {
        long circleCount = 0;
        Random random = new Random();

        for (int i = 0; i < iterators; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (Math.pow(x - CENTER_POS, 2) + Math.pow(y - CENTER_POS, 2) <= Math.pow(RADIUS, 2)) {
                circleCount++;
            }
        }
        return 4 * ((double) circleCount / iterators);
    }
}
