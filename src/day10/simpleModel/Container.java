package day10.simpleModel;

import java.util.*;

/**
 * Created by IVG 2015
 */
public class Container<T extends AppleTech> {

    private List<T> data;

    public Container() {
        data = new ArrayList<T>();
    }

    public void addDevice(T device) {
        data.add(device);
    }

    public T getDevice(int idx) {
        return data.get(idx);
    }

    public void removeDevice(T device) {
        data.remove(device);
    }

    public void sort() {
        Collections.sort(data);
    }

    public void copy(List<? extends AppleTech> src, List<? super AppleTech> data) {
        data.addAll(src);
    }

}
