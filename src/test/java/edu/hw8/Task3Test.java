package edu.hw8;

import edu.hw8.Task3.Database;
import edu.hw8.Task3.MultiIteratorPasswords;
import edu.hw8.Task3.SingleIteratorPasswords;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("тест однопоточного перебора паролей")
    void testSingleIteratorPasswords() {
        Database database = new Database();
        SingleIteratorPasswords iteratorPasswords = new SingleIteratorPasswords();
        iteratorPasswords.iteratePasswords(database);
        iteratorPasswords.printHackedPersons();
    }

    @Test
    @DisplayName("тест скорости многопоточного и однопоточного перебора")
    void testMultiIteratorPasswords() {
        Database database = new Database();
        MultiIteratorPasswords multiIterator = null;
        long start;
        long end;
        for (int j = 1; j <= 10; j++) {
            long sumTimes = 0;
            int countTimes = 3;
            for (int i = 0; i < countTimes; i++) {
                start = System.nanoTime();
                multiIterator = new MultiIteratorPasswords(j);
                multiIterator.hackDatabase(database);
                end = System.nanoTime();
                sumTimes += end - start;
            }
            System.out.printf("Потоков: %d\t Время: %f секунд\n", j, ((double)sumTimes / countTimes) / 1_000_000_000d);
        }
        multiIterator.printHackedPersons();
    }
}
