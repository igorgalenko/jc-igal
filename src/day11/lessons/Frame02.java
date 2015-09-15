package day11.lessons;

/**
 * Created by IVG 2015
 * Выведи числа от 0 до 300 предварительно преобразовав их в тип byte
 */
public class Frame02 {

    public static void main(String[] args) {
        int i = 0;
        while (i <= 300) {
            System.out.print((byte) i);
            System.out.print(" ");
            i++;
        }
    }
}
