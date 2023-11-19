package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("тест пятого задания hw3")
    void task5Test() {
        assertThat(parseContacts(new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, TypeSorting.ASC))
            .isEqualTo(new String[]{"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"});

        assertThat(parseContacts(new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, TypeSorting.DESC))
            .isEqualTo(new String[]{"Carl Gauss", "Leonhard Euler", "Paul Erdos"});

        assertThat(parseContacts(new String[]{"Denis Utev", "Isaac Newton", "Albert Einstein", "Danil Utev"}, TypeSorting.ASC))
            .isEqualTo(new String[]{"Albert Einstein", "Isaac Newton", "Danil Utev", "Denis Utev"});

        assertThat(parseContacts(new String[]{}, TypeSorting.DESC))
            .isEqualTo(new String[]{});

        assertThat(parseContacts(null, TypeSorting.DESC))
            .isEqualTo(new String[]{});
    }
}
