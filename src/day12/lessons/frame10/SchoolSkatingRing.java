package day12.lessons.frame10;

/**
 * Created by IVG 2015
 */
public class SchoolSkatingRing implements SkatingRing {
    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName() + " get skates");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        System.out.println(skater.getName() + " returned skates");
    }
}
