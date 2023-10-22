package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String ans, int maxAttempts) {
        answer = ans;
        userAnswer = new char[ans.length()];
        for(int i = 0; i < ans.length(); i++) {
            userAnswer[i] = '*';
        }
        this.maxAttempts = maxAttempts;
    }

    @NotNull GuessResult guess(char guess){
        boolean isSuccessfulGuess = false;
        attempts++;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = answer.charAt(i);
                isSuccessfulGuess = true;
            }
        }
        if (isSuccessfulGuess) {
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        } else {
            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
        }
    }
    @NotNull GuessResult giveUp(){
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }
}
