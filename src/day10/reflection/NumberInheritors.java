package day10.reflection;

import day10.simpleModel.AppleTech;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import java.lang.Number;
import java.util.Observer;
import java.util.Set;

/**
 * Created by IVG 2015
 */
public class NumberInheritors {
    public static void main(String[] args) {

        System.out.println(Number.class.getPackage().getName());
        Reflections reflections = new Reflections(ClasspathHelper.forPackage(Number.class.getPackage().getName()));
        System.out.println(reflections.getSubTypesOf(Number.class).size());
//        Set<Class<? extends Number>> inheritors =
//                System.out.println(inheritors.size());
    }
}
