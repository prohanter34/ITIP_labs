package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopWords {
    public static void main(String[] args) {
        String path = "src/lab6/topWords.txt";
        String[] words = topWords(path);
        for (String i : words) {
            System.out.println(i);
        }
    }

    public static String[] topWords(String path) {
        StringBuilder textBuilder = new StringBuilder();
        File file = new File(path);
        int c;
        try (FileReader reader = new FileReader(file);) {
            while ((c=reader.read()) != -1) {
                textBuilder.append((char)c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String text = textBuilder.toString();
        Pattern pattern = Pattern.compile("\\b[A-Z]?[a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        HashMap<String, Integer> map = new HashMap<>();
        String word;
        while (matcher.find()) {
            word = matcher.group();
            Integer count = map.get(word);
            if (count != null) {
                map.put(word, count+=1);
            } else {
                map.put(word, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        String[] out = new String[10];
        for (int i = 0; i < 10 && i < list.size() - 1; i++) {
            out[i] = list.get(i).getKey();
        }
        return out;
    }
}
