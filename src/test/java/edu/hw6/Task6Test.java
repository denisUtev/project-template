package edu.hw6;

import edu.hw6.Task6.Task6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("тест регистрации всех портов")
    void testRegistrateAllPorts() {
        Task6.registrateAllPorts();
    }
}
