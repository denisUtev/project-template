package edu.hw8;

import edu.hw8.Task1.ClientQuotes;
import edu.hw8.Task1.MultiServerQuotes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("тест одного клиента")
    void testSingleClient() {
        MultiServerQuotes serverQuotes = new MultiServerQuotes(1);
        serverQuotes.start();

        ClientQuotes client = new ClientQuotes();
        assertThat(client.isConnected()).isEqualTo(true);

        String quote = client.getQuoteByKeyWord("личности");
        assertThat(quote).isEqualTo("Не переходи на личности там, где их нет");

        String quote2 = client.getQuoteByKeyWord("интеллект");
        assertThat(quote2).isEqualTo("Чем ниже интеллект, тем громче оскорбления");

        client.close();
        serverQuotes.interrupt();
    }

    @Test
    @DisplayName("тест двух клиентов")
    void testTwoClients() {
        MultiServerQuotes serverQuotes = new MultiServerQuotes(10);
        serverQuotes.start();

        ClientQuotes client1 = new ClientQuotes();
        ClientQuotes client2 = new ClientQuotes();
        assertThat(client1.isConnected()).isEqualTo(true);
        assertThat(client2.isConnected()).isEqualTo(true);

        String quote1 = client1.getQuoteByKeyWord("личности");
        assertThat(quote1).isEqualTo("Не переходи на личности там, где их нет");
        String quote2 = client2.getQuoteByKeyWord("интеллект");
        assertThat(quote2).isEqualTo("Чем ниже интеллект, тем громче оскорбления");

        client1.close();
        client2.close();
        serverQuotes.interrupt();
    }

    @Test
    @DisplayName("тест двух клиентов при переполнении пула потоков")
    void testTwoClientsOverPool() {
        MultiServerQuotes serverQuotes = new MultiServerQuotes(1);
        serverQuotes.start();

        Thread client1Thread = new Thread(() -> {
            ClientQuotes client1 = new ClientQuotes();
            assertThat(client1.isConnected()).isEqualTo(true);
            String quote1 = client1.getQuoteByKeyWord("личности");
            assertThat(quote1).isEqualTo("Не переходи на личности там, где их нет");
            client1.close();
        });
        client1Thread.start();

        Thread client2Thread = new Thread(() -> {
            ClientQuotes client2 = new ClientQuotes();
            assertThat(client2.isConnected()).isEqualTo(true);
            String quote2 = client2.getQuoteByKeyWord("интеллект");
            assertThat(quote2).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
            client2.close();
        });
        client2Thread.start();

        try {
            client1Thread.join();
            client2Thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        serverQuotes.interrupt();
    }

    @Test
    @DisplayName("тест клиента при изначально выключенном сервере")
    void testTwoClientsAndClosedServer() {
        Thread client1Thread = new Thread(() -> {
            ClientQuotes client1 = new ClientQuotes();
            assertThat(client1.isConnected()).isEqualTo(true);
            String quote1 = client1.getQuoteByKeyWord("личности");
            assertThat(quote1).isEqualTo("Не переходи на личности там, где их нет");
            client1.close();
        });
        client1Thread.start();

        MultiServerQuotes serverQuotes = new MultiServerQuotes(10);
        serverQuotes.start();

        Thread client2Thread = new Thread(() -> {
            ClientQuotes client2 = new ClientQuotes();
            assertThat(client2.isConnected()).isEqualTo(true);
            String quote2 = client2.getQuoteByKeyWord("интеллект");
            assertThat(quote2).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
            client2.close();
        });
        client2Thread.start();

        try {
            client1Thread.join();
            client2Thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        serverQuotes.interrupt();
    }
}
