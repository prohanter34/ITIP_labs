package lab4;

public class Main {

    public static void main(String[] args) {
        String str = "dde";
        try {
            Integer num = MyInteger.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}
