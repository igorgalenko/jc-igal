package day12.lessons.frame10;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IVG 2015
 */
public class VipSkatingRink implements SkatingRing {

    private Queue<Skates> skatesList = new LinkedBlockingQueue<>();

    public VipSkatingRink() {

        for (int i = 0; i < 3; i++) {
            skatesList.add(new Skates());
        }
    }

    @Override
    public Skates getSkates(Skater skater) {

        Skates skates = skatesList.poll();

        if (skates != null) {
            System.out.println(skater.getName() + " get skates");
        }

        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesList.add(skates);
        System.out.println(skater.getName() + " returned skates");
    }
}
