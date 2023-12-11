package edu.hw8.Task1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MonoServerQuotes extends Thread {

    private final Socket socket;
    private static final int BUFFER_CAPACITY = 8192;

    public MonoServerQuotes(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream())) {
            while (socket.isConnected()) {
                String keyWord = getClientRequest();
                if (keyWord.equals("socket closed")) {
                    break;
                }

                String answer = QuoteDB.getQuote(keyWord);
                if (!answer.isEmpty()) {
                    sendAnswerToClient(outputStream, answer);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getClientRequest() {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
            ByteArrayOutputStream requestStream;
            ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            int b;
            while (inputStream.available() > 0 && (b = inputStream.read()) != -1) {
                readBuffer.put((byte) b);
            }
            readBuffer.flip();

            requestStream = new ByteArrayOutputStream();
            while (readBuffer.hasRemaining()) {
                requestStream.write(readBuffer.get());
            }
            return requestStream.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendAnswerToClient(BufferedOutputStream outputStream, String answer) {
        try {
            ByteBuffer writeBuffer = ByteBuffer.allocate(answer.getBytes(StandardCharsets.UTF_8).length);
            writeBuffer.put(answer.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            outputStream.write(writeBuffer.array());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
