package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    @DisplayName("тест третьего задания hw2")
    void task3Test() {

        PopularCommandExecutor faultyCommandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        PopularCommandExecutor defaultCommandExecutor = new PopularCommandExecutor(new DefaultConnectionManager(), 10);

        assertThrows(
            ConnectionException.class,
            faultyCommandExecutor::updatePackages
        );

        assertDoesNotThrow(defaultCommandExecutor::updatePackages);
    }
}
