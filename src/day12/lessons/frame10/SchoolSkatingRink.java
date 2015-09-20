package day12.lessons.frame10;

/**
 * Created by IVG 2015
 */
public class SchoolSkatingRink implements SkatingRing {
    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName() + " get skates");
        Demo.canGet--;
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        Demo.canGet++;
        System.out.println(skater.getName() + " returned skates");
    }
}
