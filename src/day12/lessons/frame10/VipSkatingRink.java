package day12.lessons.frame10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IVG 2015
 */
public class VipSkatingRink implements SkatingRing {

    private Lock skatesLock;

    private List<Skates> skatesList;

    public VipSkatingRink() {
        skatesList = new LinkedList<>();
        skatesLock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            skatesList.add(new Skates());
        }
    }

    @Override
    public Skates getSkates(Skater skater) {
        if (skatesList.isEmpty()) {
            try {
                synchronized (skatesList) {
                    skatesList.wait();
                }
            } catch (InterruptedException e) {
                //
            }
        }

        skatesLock.lock();
        skatesList.remove(0);
        skatesLock.unlock();

        System.out.println(skater.getName() + " get skates");

        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesList.add(skates);
        synchronized (skatesList) {
            skatesList.notify();
        }
        System.out.println(skater.getName() + " returned skates");
    }
}
