package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("тест класса HackerNews")
    void testHackerNews() {
        System.out.println(Arrays.toString(hackerNewsTopStories()));
        String newsTitle = news(37570037);
        System.out.println(newsTitle);
        assertThat(newsTitle).isEqualTo("JDK 21 Release Notes,type");
    }
}
