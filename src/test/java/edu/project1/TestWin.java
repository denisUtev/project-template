package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestWin {

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
