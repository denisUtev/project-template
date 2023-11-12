package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private static final double MAX_NUM_CONNECTION = 0.5;

    @Override
    public Connection getConnection() {
        Random random = new Random();
        if (random.nextDouble() > MAX_NUM_CONNECTION) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
