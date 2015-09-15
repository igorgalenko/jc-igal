package day11.lessons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * Created by IVG 2015
 */
public class Frame04 {
    private static byte[] bytes;

    public static void printStreamData(ByteArrayInputStream byteArrayIn) {

        int i;
        while ((i = byteArrayIn.read()) != -1) {
            System.out.print(i);
            System.out.print(" ");
        }

    }

    public static void main(String[] args) {
        bytes = new byte[]{1, 2, 3, 4, 5} ;
        printStreamData(new ByteArrayInputStream(bytes));
        bytes = "Igor".getBytes();
        printStreamData(new ByteArrayInputStream(bytes));
    }

}
