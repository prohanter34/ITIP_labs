package lab5;

import lab4.ArrayAverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {

    }

    public static Float[] findNumbers(String text) {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(text);
        ArrayList<Float> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(Float.parseFloat(matcher.group()));
        }
        Float[] out = new Float[list.size()];
        out = list.toArray(out);
        return out;
    }
}
