package edu.hw3;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("тест первого задания hw3")
    void task1Test() {
        assertThat(encodeAtbash("Hello world!")).isEqualTo("Svool dliow!");
        assertThat(encodeAtbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"))
            .isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }
}
