package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Тест неверного ответа")
    void testFailGuess() {

        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('q');
        assertThat(result.attempt()).isEqualTo(1);
        assertThat(result instanceof GuessResult.FailedGuess).isEqualTo(true);
    }

    @Test
    @DisplayName("Тест Проигрыша")
    void testDefeat() {
        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('q');
        result = testSession.guess('q');
        result = testSession.guess('q');
        assertThat(result.attempt()).isEqualTo(result.maxAttempts());
        assertThat(result instanceof GuessResult.Defeat).isEqualTo(true);
    }

    @Test
    @DisplayName("Тест Правильного ответа")
    void testSuccesGues() {
        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('a');
        assertThat(result.attempt()).isEqualTo(0);
        assertThat(result instanceof GuessResult.SuccessfulGuess).isEqualTo(true);
    }

    @Test
    @DisplayName("Тест Выигрыша")
    void testWin() {
        Session testSession = new Session("abc", 3);
        GuessResult result = testSession.guess('a');
        result = testSession.guess('b');
        result = testSession.guess('c');
        assertThat(result.attempt()).isEqualTo(0);
        assertThat(result instanceof GuessResult.Win).isEqualTo(true);
    }
}
