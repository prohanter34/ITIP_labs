package lab4;

import java.io.*;
import java.nio.channels.WritePendingException;

public class CopyFile {

    public static void main(String[] args) {

        boolean result = copyFile("src/lab4/first.txt", "src/lab4/second.txt");
        System.out.println(result);

    }

    private static boolean copyFile(String path1, String path2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        try (FileReader reader = new FileReader(path1);) {
            int c;
            while((c=reader.read())!=-1){
                stringBuilder1.append((char) c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Копируемый файл не найден");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        try (FileWriter writer = new FileWriter(path2)) {
            writer.write(stringBuilder1.toString());
        } catch (WritePendingException e) {
            System.out.println("Ошибка записи");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
