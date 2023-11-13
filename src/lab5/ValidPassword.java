package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {

    public static void main(String[] args) {
        String password = "0frf598addeDFE@!";
        System.out.println(validPassword(password));
        password = "qwerTY121";
        System.out.println(validPassword(password));
    }
    public static boolean validPassword(String password) {
        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}
