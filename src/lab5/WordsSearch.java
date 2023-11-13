package lab5;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsSearch {
    public static void main(String[] args) {
        char letter = 'd';
        String text = "dim fdui dress drop. forgot";
        for (String i : searchWords(letter,text)) {
            System.out.println(i);
        }
    }

    public static String[] searchWords(char letter, String text) {
        Pattern pattern = Pattern.compile("(\\b[dD][a-z]*\\b)");
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        String[] out = new String[list.size()];
        out = list.toArray(out);
        return out;
    }
}
