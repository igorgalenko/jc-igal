package day10.simpleModel;

/**
 * Created by IVG 2015
 */
public abstract class AppleTech implements Comparable{

    private String name;

    public AppleTech() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {

        AppleTech at = (AppleTech) o;

        return name.compareTo(at.name);
    }
}
