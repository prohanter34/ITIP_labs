package lab5;

import lab4.ArrayAverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Hello 99.99 some text 88 tg 998, 767.7979 price is 989$";
        Float[] numbers = findNumbers(text);
        for (Float i : numbers) {
            System.out.println(i);
        }

    }

    public static Float[] findNumbers(String text) {
        Pattern pattern = Pattern.compile("[0-9]+[.]?[0-9]+?");
        Matcher matcher = pattern.matcher(text);
        ArrayList<Float> list = new ArrayList<>();
        while (matcher.find()) {
            try {
                list.add(Float.parseFloat(matcher.group()));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        Float[] out = new Float[list.size()];
        out = list.toArray(out);
        return out;
    }
}
