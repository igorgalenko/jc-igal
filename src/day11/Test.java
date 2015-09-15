package day11;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Created by IVG 2015
 */
public class Test {

    public static void main(String[] args) {
        String s = "privet";
        System.out.println(s);
        method1(s);
        System.out.println(s);
    }

    private static void method1(String a) {
        a = "poka";
    }
}


