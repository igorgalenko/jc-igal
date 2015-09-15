package day11.lessons;

import java.io.*;

/**
 * Created by IVG 2015
 * перепеши метод copyFile так, чтобы он использовал буфер в 256 байт
 */
public class Frame10 {

    public static void copyFile(File source) {
        String fileName = source.getName();
        fileName = fileName.replaceFirst("\\.", "Copy.");
        File dest = new File(fileName);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source), 256);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            int i;
            while ((i = bis.read()) > 0) {
                bos.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        copyFile(new File("111.txt"));
    }
}
