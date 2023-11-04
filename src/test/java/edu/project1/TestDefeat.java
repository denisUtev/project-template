package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestDefeat {

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
}
