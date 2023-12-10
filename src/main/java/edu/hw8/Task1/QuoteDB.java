package edu.hw8.Task1;

import java.util.HashMap;
import java.util.Map;

public final class QuoteDB {

    private QuoteDB() {

    }

    private static final Map<String, String> DICTIONARY_QUOTES = new HashMap<>() {{
        put("личности", "Не переходи на личности там, где их нет");
        put("оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        put("глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }};

    public static String getQuote(String keyWord) {
        if (DICTIONARY_QUOTES.containsKey(keyWord)) {
            return DICTIONARY_QUOTES.get(keyWord);
        }
        return "";
    }

}
