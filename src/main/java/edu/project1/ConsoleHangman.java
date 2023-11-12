package edu.project1;

import java.util.Scanner;

public class ConsoleHangman {

    Scanner console = new Scanner(System.in);

    private final static String EXIT_COMMAND = "esc";

    public void run() {
        Dictionary dict = new StandartDictionary();
        String answer = dict.randomWord();
        Session session = new Session(answer, answer.length());
        boolean isGameOver = false;

        while (!isGameOver) {
            String input = readInput();
            if (input.equals(EXIT_COMMAND)) {
                printState(session.giveUp());
                isGameOver = true;
            } else {
                GuessResult stepResult = tryGuess(session, input.charAt(0));
                printState(stepResult);
                if (stepResult instanceof GuessResult.Win || stepResult instanceof GuessResult.Defeat) {
                    isGameOver = true;
                }
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private String readInput() {
        System.out.println("Guess a letter: ");
        while (true) {
            String input = console.nextLine();
            if (input.equals(EXIT_COMMAND) || input.length() == 1) {
                return input;
            } else {
                System.out.println("Repeat please: ");
            }
        }
    }

    private GuessResult tryGuess(Session session, char input) {
        return session.guess(input);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void printState(GuessResult guess) {
        System.out.printf("The word: %s \n", String.valueOf(guess.state()));
        System.out.println(guess.message());
    }
}
