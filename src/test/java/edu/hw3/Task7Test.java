package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw3.Task7.*;
public class Task7Test {

    @Test
    @DisplayName("тест седьмого задания hw3")
    void task7Test() {
        TreeMap<String, String> tree = new TreeMap<>(new TreeMapComparator());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
