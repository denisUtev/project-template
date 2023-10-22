package edu.hw2;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("тест четвертого задания hw2")
    void task4Test() {
        Task4.CallingInfo textCall = Task4.getCallingInfo();
        System.out.println(textCall.className());
        assertThat(textCall.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(textCall.methodName()).isEqualTo("task4Test");
    }
}
