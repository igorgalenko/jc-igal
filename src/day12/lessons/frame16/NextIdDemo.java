package day12.lessons.frame16;

import java.util.concurrent.CountDownLatch;

/**
 * Created by IVG 2015
 */
public class NextIdDemo {
    public static void main(String[] args) {

        final IdGenerator idGenerator = new IdGenerator();
        final CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(idGenerator.getNextId());
                }
            }).start();

            latch.countDown();

        }
    }

}
