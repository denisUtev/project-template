package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static edu.hw3.Task2.clusterize;
import static edu.hw3.Task3.freqDict;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("тест третьего задания hw3")
    void task3Test() {
        assertThat(freqDict(new String[]{"a", "bb", "a", "bb"}))
            .isEqualTo(new HashMap<String, Integer>() {{
            put("bb", 2);
            put("a", 2);
            }});

        assertThat(freqDict(new String[]{"this", "and", "that", "and"}))
            .isEqualTo(new HashMap<String, Integer>() {{
                put("that", 1);
                put("and", 2);
                put("this", 1);
            }});

        assertThat(freqDict(new String[]{"код", "код", "код", "bug"}))
            .isEqualTo(new HashMap<String, Integer>() {{
                put("код", 3);
                put("bug", 1);
            }});

        assertThat(freqDict(new Integer[]{1, 1, 2, 2}))
            .isEqualTo(new HashMap<Integer, Integer>() {{
                put(1, 2);
                put(2, 2);
            }});
    }
}
