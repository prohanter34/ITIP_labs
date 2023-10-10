package lab4;

public class MyInteger {

    public void parseInt(String str) throws CustomNumberFormatException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException(e.getMessage());
        }
    }

}
class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}
