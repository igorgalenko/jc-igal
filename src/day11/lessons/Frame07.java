package day11.lessons;

import java.io.*;
//import java.nio.file.CopyOption;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;

/**
 * Created by IVG 2015
 * Напиши метод copyFile(File), который копирует переданный файл,
 * при этом, в названии добавляется 'Copy'
 */
public class Frame07 {

    public static void copyFile(File source) {
        String fileName = source.getName();
        fileName = fileName.replaceFirst("\\.", "Copy.");
        File dest = new File(fileName);


        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            int i;
            byte[] buffer = new byte[2048];
            while ((i = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {
        copyFile(new File("111.txt"));
    }

}
