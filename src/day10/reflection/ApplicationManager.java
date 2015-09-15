package day10.reflection;

/**
 * Created by IVG 2015
 */
public class ApplicationManager {

    public ApplicationManager(Class aClass) {
        if (aClass.isAnnotationPresent(Service.class)) {
            System.out.println("Good class");
        } else {
            System.out.println("Bad class");
        }
    }
}
