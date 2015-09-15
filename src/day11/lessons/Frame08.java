package day11.lessons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by IVG 2015
 * Измени метод printStreamData так, чтобы он принимал InputStream
 * и распечатайте с его помощью текстовый файл
 */
public class Frame08 {

    public static void printStreamData(InputStream inputStream) {

        try {
            int i;
            while ((i = inputStream.read()) > 0) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        File file = new File("111.txt");
        try {
            printStreamData(Files.newInputStream(file.toPath(), StandardOpenOption.READ));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
