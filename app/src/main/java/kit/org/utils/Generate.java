package kit.org.utils;

import kit.org.Application;
import kit.org.model.Quote;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Generate {
    private static final String data = Objects
            .requireNonNull(Application.class
            .getClassLoader()
            .getResource("quotes.txt"))
            .getPath();

    public static Map<Long, Quote> getEntities() {
        long index = 0L;
        Map<Long, Quote> entities = new HashMap<>();
        List<String> quoreList = new ArrayList<>();
        try {
            quoreList = Files.lines(Paths
                            .get(data))
                            .toList()
                            .stream()
                            .toList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (index < quoreList.size()) {
            var tempText = quoreList.get((int) index);
            Quote quote = new Quote(tempText);
            entities.put(index, quote);
            index++;
        }
        return entities;
    }
}
