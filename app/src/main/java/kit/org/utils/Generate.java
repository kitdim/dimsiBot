package kit.org.utils;

import kit.org.Application;
import kit.org.model.Quote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Generate {
    public static Map<Long, Quote> getEntities() {
        long index = 0L;
        Map<Long, Quote> entities = new HashMap<>();
        List<String> quoreList = getData("quotes.txt");
        while (index < quoreList.size()) {
            String tempText = quoreList.get((int) index);
            Quote quote = new Quote(tempText);
            entities.put(index, quote);
            index++;
        }
        return entities;
    }

    public static String getBotInfo(int numbParameters) {
        List<String> parameters = getData("botConfig.txt");

        return parameters.get(numbParameters).split("=")[1];
    }
    private static List<String> getData(String nameFile) {
        String data =  Objects
                .requireNonNull(Application.class
                .getClassLoader()
                .getResource(nameFile))
                .getPath();
        List<String> result;
        try {
            result = Files.lines(Paths
                    .get(data))
                    .toList()
                    .stream()
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
