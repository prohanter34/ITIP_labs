package lab1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String str) {
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            s += String.valueOf(str.charAt(i));
        }
        return s;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

}
