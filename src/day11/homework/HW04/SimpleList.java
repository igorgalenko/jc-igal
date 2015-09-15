package day11.homework.HW04;

/**
 * Created by IVG 2015
 */
import java.util.Iterator;

public interface SimpleList<T> {

    public void add(T object);

    public boolean contains(T object);

    public void remove(T object);

    public int size();

    public Iterator<T> iterator();
}
