package edu.hw7;

import edu.hw7.Task1.AtomicCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task1Test {

    @Test
    @DisplayName("тест потокобезопасности и отсутствия состояния гонки")
    void testThreadSafety() {
        AtomicCounter counter1 =  new AtomicCounter(3, 100);
        counter1.waitThreads();
        assertThat(counter1.getCounter()).isEqualTo(300);

        AtomicCounter counter2 =  new AtomicCounter(35, 5555);
        counter2.waitThreads();
        assertThat(counter2.getCounter()).isEqualTo(35 * 5555);
    }
}
