package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiServerQuotes extends Thread {

    private final ThreadPoolExecutor poolExecutor;
    private final ServerSocket server;
    private static final int PORT = 18080;

    public MultiServerQuotes(int poolCapacity) {
        poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(poolCapacity);
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Socket socket;
        while (!isInterrupted()) {
            try {
                socket = server.accept();
                poolExecutor.submit(new MonoServerQuotes(socket));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        poolExecutor.close();
        poolExecutor.shutdown();
    }
}
