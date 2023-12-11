package edu.hw8.Task3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Database {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Map<String, String> database = new HashMap<>();
    private final Random random = new Random();
    private static final int COUNT_PERSONS = 50;
    private static final int COUNT_SYMBOLS = 4;

    public Database() {
        try {
            generateDatabase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean containsKey(String key) {
        return database.containsKey(key);
    }

    public String get(String key) {
        return database.get(key);
    }

    public int size() {
        return database.size();
    }

    @SuppressWarnings("MagicNumber")
    private void generateDatabase() throws NoSuchAlgorithmException {
        for (int i = 0; i < COUNT_PERSONS; i++) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(getRandomPassword().getBytes());
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String password = bigInt.toString(16);
            database.put(password, "Person" + i);
        }
    }

    private String getRandomPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < COUNT_SYMBOLS; i++) {
            int index = random.nextInt(0, ALPHABET.length());
            password.append(ALPHABET.charAt(index));
        }
        return password.toString();
    }
}
