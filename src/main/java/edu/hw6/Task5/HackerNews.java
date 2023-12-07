package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HackerNews {

    private HackerNews() {

    }

    public static final String HTTP_LINK = "https://hacker-news.firebaseio.com/v0/";
    public static final String TOP_STORIES_JSON = "topstories.json";
    public static final String ITEM_JSON = "item/";

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_LINK + TOP_STORIES_JSON))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.stream(response.body()
                .substring(1, response.body().length() - 1)
                .split(","))
                .map(Integer::parseInt)
                .mapToLong(x -> x)
                .toArray();
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public static String news(long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_LINK + ITEM_JSON + id + ".json"))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseTitleFromJSON(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String parseTitleFromJSON(String bodyNews) {
        Pattern titleStrokePattern = Pattern.compile("\"title\":\".*\"");
        Matcher titleMatcher = titleStrokePattern.matcher(bodyNews);
        if (titleMatcher.find()) {
            String titleStroke = titleMatcher.group();
            return titleStroke.split(":")[1].replace("\"", "");
        }
        return null;
    }
}
