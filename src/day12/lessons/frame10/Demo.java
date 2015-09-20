package day12.lessons.frame10;

import java.util.Random;

/**
 * Created by IVG 2015
 */
public class Demo {

    protected static volatile int canGet = 5;

    public static void main(String[] args) {
        System.out.println("Open");

        final SkatingRing skatingRing = new VipSkatingRink();
        final Random random = new Random();

        for (int i = 0; i < 20; i++) {
            final Skater skater = new Skater("Skater " + i);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Skates skates = null;
                    while (skates == null) {
                        skates = skatingRing.getSkates(skater);
                        sleep(random.nextInt(2000));
                    }
                    skatingRing.returnSkates(skates, skater);
                }
            }).start();
        }
        sleep(random.nextInt(1000));
    }

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
