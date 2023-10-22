package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection {

    private static final double MAX_NUM_CONNECTION = 0.5;

    @Override
    public void execute(String command) {
        Random random = new Random();
        if (random.nextDouble() > MAX_NUM_CONNECTION) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
