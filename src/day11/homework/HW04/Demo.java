package day11.homework.HW04;

import java.io.*;

/**
 * Created by IVG 2015
 */
public class Demo {

    private static final boolean CREATE_NEW = true;

    public static void main(String[] args) {

        if (CREATE_NEW) {

            try (FileList<Integer> integerSimpleList = new FileList<>()) {

                integerSimpleList.add(1010);
                integerSimpleList.add(212);
                integerSimpleList.add(30);
                integerSimpleList.add(5);

                for (Object obj : integerSimpleList) {
                    System.out.println(obj.toString());
                }

                System.out.println("size = " + integerSimpleList.size());
                integerSimpleList.remove(5);
                System.out.println("size = " + integerSimpleList.size());

                integerSimpleList.add(4);

                for (Object obj : integerSimpleList) {
                    System.out.println(obj.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try (FileList<Integer> integerSimpleList = new FileList<>("SimpleList.txt")) {

                for (Object obj : integerSimpleList) {
                    System.out.println(obj.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
