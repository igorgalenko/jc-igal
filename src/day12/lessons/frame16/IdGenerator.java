package day12.lessons.frame16;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by IVG 2015
 */
public class IdGenerator {

    AtomicLong atomicLong = new AtomicLong();

    public long getNextId() {

        return atomicLong.incrementAndGet();
    }
}
