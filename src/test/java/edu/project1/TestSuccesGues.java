package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSuccesGues {

    @Test
    @DisplayName("Тест Правильного ответа")
    void testSuccesGues() {
        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('a');
        assertThat(result.attempt()).isEqualTo(0);
        assertThat(result instanceof GuessResult.SuccessfulGuess).isEqualTo(true);
    }
}
