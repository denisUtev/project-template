package edu.hw8.Task3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class SingleIteratorPasswords {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Map<String, String> hackedPersons = new HashMap<>();
    private final byte[] iteratorSymbols = new byte[]{0, 0, 0, -1};
    private static final int COUNT_SYMBOLS = 4;

    public SingleIteratorPasswords() {

    }

    public void iteratePasswords(Database database) {
        while (hackedPersons.size() < database.size()) {
            String newPassword = nextPassword();
            String passwordMD5 = getMD5(newPassword);
            if (database.containsKey(passwordMD5)) {
                hackedPersons.put(newPassword, database.get(passwordMD5));
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void printHackedPersons() {
        for (String key : hackedPersons.keySet()) {
            System.out.println(key + ": " + hackedPersons.get(key));
        }
    }

    private String nextPassword() {
        iteratorSymbols[COUNT_SYMBOLS - 1]++;
        for (int i = COUNT_SYMBOLS - 1; i >= 1; i--) {
            if (iteratorSymbols[i] >= ALPHABET.length()) {
                iteratorSymbols[i] = 0;
                iteratorSymbols[i - 1]++;
            }
        }
        if (iteratorSymbols[0] >= ALPHABET.length()) {
            return "-1";
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < COUNT_SYMBOLS; i++) {
            password.append(ALPHABET.charAt(iteratorSymbols[i]));
        }
        return password.toString();
    }

    @SuppressWarnings("MagicNumber")
    private String getMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(password.getBytes());
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
