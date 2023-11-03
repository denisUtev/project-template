package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw3.Task8.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("тест восьмого задания hw3")
    void task8Test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = new BackwardIterator<>(list);
        int index = list.size() - 1;
        while (iterator.hasNext()) {
            assertThat(iterator.next()).isEqualTo(list.get(index--));
        }
    }
}
