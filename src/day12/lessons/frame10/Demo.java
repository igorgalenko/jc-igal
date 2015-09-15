package day12.lessons.frame10;

import java.util.Random;

/**
 * Created by IVG 2015
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("Open");

        final SkatingRing skatingRing = new SchoolSkatingRing();
        final Random random = new Random();

        for (int i = 0; i < 10; i++) {
            final Skater skater = new Skater("Skater " + i);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Skates skates = skatingRing.getSkates(skater);
                    sleep(random.nextInt(2000));
                }
            }).start();
        }
        sleep(random.nextInt(2000));
    }

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
