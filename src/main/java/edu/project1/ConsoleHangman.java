package edu.project1;

import java.util.Scanner;

public class ConsoleHangman {
    public void run() {
        Dictionary dict = new StandartDictionary();
        String answer = dict.randomWord();
        Session session = new Session(answer, answer.length());
        boolean isGameOver = false;

        while (!isGameOver) {
            String input = readInput();
            if (input.equals("esc")) {
                printState(session.giveUp());
                isGameOver = true;
            } else {
                GuessResult stepResult = tryGuess(session, input.charAt(0));
                printState(stepResult);
            }
        }
    }

    private String readInput() {
        Scanner console = new Scanner(System.in);
        while (true) {
            String input = console.nextLine();
            if (input.equals("esc") || input.length() == 1) {
                return input;
            } else {
                System.out.println("Repeat please: ");
            }
        }
    }

    private GuessResult tryGuess(Session session, char input) {
        return session.guess(input);
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
    }
}
