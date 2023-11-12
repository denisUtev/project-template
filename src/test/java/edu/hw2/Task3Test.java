package edu.hw2;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Executor;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    @DisplayName("тест Connection")
    void testConnections() {

        boolean haveStableConnection = false;
        boolean haveFaultyConnection = false;
        ConnectionManager manager;

        for (int i = 0; i < 1000; i++) {
            manager = new DefaultConnectionManager();
            if (manager.getConnection() instanceof FaultyConnection) {
                haveFaultyConnection = true;
            }
            if (manager.getConnection() instanceof StableConnection) {
                haveStableConnection = true;
            }
        }

        assertThat(haveStableConnection).isEqualTo(true);
        assertThat(haveFaultyConnection).isEqualTo(true);
    }

    @Test
    @DisplayName("тест ConnectionException")
    void testConnectionException() {

        boolean haveException = false;

        for (int i = 0; i < 1000; i++) {
            try (var faultyConnection = new FaultyConnection()) {
                faultyConnection.execute("test");
            } catch (Exception e) {
                haveException = true;
            }
        }

        assertThat(haveException).isEqualTo(true);
    }

    @Test
    @DisplayName("тест ExecutorException")
    void testExecutorException() {

        boolean haveException = false;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);

        for (int i = 0; i < 1000; i++) {
            try {
                executor.updatePackages();
            } catch (Exception e) {
                haveException = true;
            }
        }

        assertThat(haveException).isEqualTo(true);
    }
}
