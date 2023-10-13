package lab4;

import javax.lang.model.type.PrimitiveType;
import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.function.Function;

public class ArrayAverage {

    public static void main(String[] args) {
        Character[] array = {'2', '3', '8', '9'};
        System.out.println(arrayAverage(array));

    }

    public static<T> float arrayAverage(T[] array) {
        float sum = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                String cl = array[i].toString();
                sum += Float.parseFloat(cl);
            }
            return sum / array.length;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (NumberFormatException e) {
            System.out.println("type error");
        } catch (Exception e) {
            System.out.println("dede");
        }
        return 0;
    }
}
