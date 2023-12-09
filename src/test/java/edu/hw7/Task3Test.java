package edu.hw7;

import edu.hw7.Task3.MyDatabase3;
import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("тест работы базы данных, использующей synchronized")
    void testThreadSafety() {
        PersonDatabase database = new MyDatabase3();
        database.add(new Person(0, "Denis", "q", "123"));
        database.add(new Person(1, "Peter1", "s", "128"));
        database.add(new Person(2, "Kristina", "q", "235"));
        database.add(new Person(3, "Peter2", "w", "128"));
        database.add(new Person(4, "Kristina", "s", "999"));
        for (int i = 0; i < 1000; i++) {
            database.add(new Person(5 + i, "Peter%d".formatted(i + 3), "s", "128"));
        }
        for (int i = 0; i < 555; i++) {
            database.add(new Person(1006 + i, "Kristina", "s%d".formatted(i), "128%d".formatted(i)));
        }

        List<Thread> threads = new ArrayList<>();
        AtomicInteger countFinds = new AtomicInteger(0);
        threads.add(new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                database.add(new Person(3000 + i, "powjdefj%d".formatted(i + 3), "wergthtyju", "000"));
            }
        }));
        threads.add(new Thread(() -> {
            int count = database.findByName("Kristina").size();
            countFinds.addAndGet(count);
        }));
        threads.add(new Thread(() -> {
            int count = database.findByAddress("s").size();
            countFinds.addAndGet(count);
        }));
        threads.add(new Thread(() -> {
            int count = database.findByPhone("128").size();
            countFinds.addAndGet(count);
        }));
        threads.forEach(Thread::start);
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        assertThat(countFinds.get()).isEqualTo(2561);
    }
}
