package day11.lessons;

import java.io.*;

/**
 * Created by IVG 2015
 */
public class Frame14 {

    public static void main(String[] args) {

        PrintStream console = System.out;
        System.setOut(getPrintStream());
        System.out.println("Hello!");
        System.out.println("This is log file");

        System.setOut(console);
        System.out.println("File wrote");

    }

    private static PrintStream getPrintStream() {

        try {
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(Frame14.class.getSimpleName()+"_log.txt")),true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
