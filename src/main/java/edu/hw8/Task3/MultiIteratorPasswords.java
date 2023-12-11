package edu.hw8.Task3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MultiIteratorPasswords {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Map<String, String> hackedDatabase = new HashMap<>();
    private static final int COUNT_SYMBOLS = 4;
    private final int countThreads;

    public MultiIteratorPasswords(int countThreads) {
        this.countThreads = countThreads;
    }

    public void hackDatabase(Database database) {
        StepIteratorPasswords[] iterators = new StepIteratorPasswords[countThreads];
        for (int i = 0; i < countThreads; i++) {
            iterators[i] = new StepIteratorPasswords(database, (byte) (i - 1), (byte) countThreads);
            iterators[i].start();
        }
        for (int i = 0; i < countThreads; i++) {
            try {
                iterators[i].join();
                Map<String, String> hackedPersons = iterators[i].getHackedPersons();
                for (String key : hackedPersons.keySet()) {
                    hackedDatabase.put(key, hackedPersons.get(key));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void printHackedPersons() {
        System.out.println("Hacked Database:");
        for (String key : hackedDatabase.keySet()) {
            System.out.println(key + ": " + hackedDatabase.get(key));
        }
    }

    private class StepIteratorPasswords extends Thread {

        private final Map<String, String> hackedPersons = new HashMap<>();
        private final byte[] iteratorSymbols = new byte[]{0, 0, 0, -1};
        private final byte step;
        private final Database database;

        StepIteratorPasswords(Database database, byte firstNum, byte step) {
            this.database = database;
            iteratorSymbols[COUNT_SYMBOLS - 1] = firstNum;
            this.step = step;
        }

        @Override
        public void run() {
            String newPassword = " ";
            while (!newPassword.equals("-1")) {
                newPassword = nextPassword();
                String passwordMD5 = getMD5(newPassword);
                synchronized (database) {
                    if (database.containsKey(passwordMD5)) {
                        hackedPersons.put(newPassword, database.get(passwordMD5));
                    }
                }
            }
        }

        public Map<String, String> getHackedPersons() {
            return hackedPersons;
        }

        private String nextPassword() {
            iteratorSymbols[COUNT_SYMBOLS - 1] += step;
            for (int i = COUNT_SYMBOLS - 1; i >= 1; i--) {
                if (iteratorSymbols[i] >= ALPHABET.length()) {
                    iteratorSymbols[i] -= (byte) ALPHABET.length();
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
}
