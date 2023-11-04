package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestFailGuess {
    @Test
    @DisplayName("Тест неверного ответа")
    void testFailGuess() {

        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('q');
        assertThat(result.attempt()).isEqualTo(1);
        assertThat(result instanceof GuessResult.FailedGuess).isEqualTo(true);
    }
}
