package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyperlink {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList();
        String current = sc.nextLine();
        while(!current.isEmpty()){
            list.add(current);
            current = sc.nextLine();
        }
        for (String i : list) {
            System.out.println(replaceLinks(i));
        }
    }

    public static String replaceLinks(String str) {
        Pattern pattern = Pattern.compile("(\\b[\\w-]{1,32}\\.[\\w-]{1,32})[^\\s@]*\\b");
        Matcher matcher = pattern.matcher(str);
        str = str.replaceAll("https://", "");
        while (matcher.find()) {
            String link = matcher.group();
            str = str.replaceAll(link, "<a href=https://" + link + ">https://" + link + "</a>");
        }
        return str;
    }


}
