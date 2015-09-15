package day11.lessons;

import java.io.*;

/**
 * Created by IVG 2015
 * создай метод changeEncoding(File file, String currentEncoding, String neededEncoding),
 * который меняет кодировку данных в файле
 */
public class Frame13 {

    public static void main(String[] args) {

        File textFile = new File("111.txt");
        changeEncoding(textFile, "Windows-1251", "CP1251");

    }

    public static void changeEncoding(File file, String currentEncoding, String neededEncoding) {

        String currentLine = null;
        String lineSep = System.getProperty("line.separator");
        StringBuilder buffer = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), currentEncoding)))
        {

            while ((currentLine = bufferedReader.readLine()) != null) {

                buffer.append(currentLine);
                buffer.append(lineSep);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), neededEncoding)))
        {
            bufferedWriter.write(buffer.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
