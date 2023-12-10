package edu.hw8.Task1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ClientQuotes {

    private Socket socket;
    private BufferedInputStream inputStream;
    private BufferedOutputStream outputStream;
    private static final String HOST = "localhost";
    private static final int PORT = 18080;
    private static final int BUFFER_CAPACITY = 8192;
    private static final String CLOSE_SOCKET_COMMAND = "socket closed";

    public ClientQuotes() {
        while (socket == null) {
            connectToServer();
        }
    }

    private void connectToServer() {
        try {
            socket = new Socket(HOST, PORT);
            inputStream = new BufferedInputStream(socket.getInputStream());
            outputStream = new BufferedOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isConnected() {
        return socket.isConnected();
    }

    public String getQuoteByKeyWord(String keyWord) {
        try {
            sendRequest(outputStream, keyWord);

            while (inputStream.available() == 0) {

            }

            return getServerAnswer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getServerAnswer() {
        try {
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

    private void sendRequest(BufferedOutputStream outputStream, String request) {
        try {
            ByteBuffer writeBuffer = ByteBuffer.allocate(request.getBytes(StandardCharsets.UTF_8).length);
            writeBuffer.put(request.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            outputStream.write(writeBuffer.array());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeConnetionWithServer() {
        try {
            ByteBuffer writeBuffer = ByteBuffer.allocate(CLOSE_SOCKET_COMMAND.getBytes(StandardCharsets.UTF_8).length);
            writeBuffer.put(CLOSE_SOCKET_COMMAND.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            outputStream.write(writeBuffer.array());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            closeConnetionWithServer();
            socket.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
