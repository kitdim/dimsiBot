package kit.org.repository;

import kit.org.model.Quote;
import kit.org.utils.Generate;

import java.util.Map;
import java.util.Random;

public class QuotesRepository {
    private static final Map<Long, Quote> quotes = Generate.getEntities();
    public static String show() {
        Random random = new Random();
        int size = quotes.size();
        return quotes.get(random.nextLong(size)).getText();
    }
}
