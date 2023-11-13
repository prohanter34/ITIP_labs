package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIP {
    public static void main(String[] args) {
        String ip = "123.32.57.1";
        System.out.println(validIP(ip));
        ip = "123.32.57.01";
        System.out.println(validIP(ip));
        ip = "256.32.57.1";
        System.out.println(validIP(ip));
    }

    public static boolean validIP(String ip) {
        ip += ".";
        Pattern pattern = Pattern.compile(
                "^(((25[0-5])|(2[1-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([0-9]))[.]){4}$"
        );
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }
}
