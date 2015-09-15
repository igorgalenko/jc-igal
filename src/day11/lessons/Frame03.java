package day11.lessons;

import java.io.ByteArrayInputStream;

/**
 * Created by IVG 2015
 */
public class Frame03 {

    public static void main(String[] args) {
        byte[] array1 = new byte[]{-10, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while((b=byteStream1.read())!=-1){

            System.out.println(b);
        }

//        String name = "Igor";
//        byte[] data = name.getBytes();
//        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(data);
//        int c;
//
//        while ((c=byteStream2.read())!=-1){
//
//            System.out.println((char)c);
//        }

    }

}
