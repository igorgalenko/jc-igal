package day10.reflection;

import day10.simpleModel.AppleTech;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * Created by IVG 2015
 */
public class ClassInfo {

    public static void printClassInfo(Class aClass) {
        System.out.println("Class Info:");
        System.out.println("package "+aClass.getPackage().getName());
        int mods = aClass.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.print("public ");
        } else if (Modifier.isPrivate(mods)) {
            System.out.print("private ");
        } else {
            System.out.print("protected ");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.print("abstract ");
        }
        if (Modifier.isFinal(mods)) {
            System.out.print("final ");
        }
        System.out.println(aClass.getSimpleName());
    }

    public static void printClassMethods(Class aClass) {
        String className = aClass.getSimpleName();
        Method[] methods = aClass.getDeclaredMethods();
        if (methods.length == 0) {
            System.out.println("There ara no methods in class " + className);
        } else {
            System.out.println(className+" Methods:");
            for (Method method : methods) {
                System.out.print(method.getReturnType() + " " + method.getName());
                System.out.print("(");
                Class[] parameters = method.getParameterTypes();
                for (Class parameter : parameters) {
                    System.out.print(parameter.getSimpleName());
                    if (!parameters[parameters.length - 1].equals(parameter)) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
        }
    }

    public static void printClassFields(Class aClass) {
        String className = aClass.getSimpleName();
        Field[] fields = aClass.getDeclaredFields();
        if (fields.length == 0) {
            System.out.println("There ara no fields in class " + className);
        } else {

            System.out.println("printing fields of Class " + className + "...");
            for (Field field : fields) {
                System.out.println(field.getType() + " " + field.getName());
            }
        }
    }

    public static <T> void initClass(Class aClass, Map<String, Object> classFieldsMap) throws Exception{

        T object = (T) aClass.newInstance();

        for (String fieldName : classFieldsMap.keySet()) {
            Field classField = aClass.getField(fieldName);
            Method classMethod = aClass.getMethod(fieldName, aClass);

        }

    }

    public static void main(String[] args) {
        printClassMethods(AppleTech.class);
        printClassInfo(AppleTech.class);
    }
}
