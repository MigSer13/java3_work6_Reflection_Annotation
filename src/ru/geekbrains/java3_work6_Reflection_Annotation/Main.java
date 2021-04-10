package ru.geekbrains.java3_work6_Reflection_Annotation;

import ru.geekbrains.java3_work6_Reflection_Annotation.Annotation.TestAnnotation;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.MalformedInputException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        //Task1
        // TestAnnotation test = new TestAnnotation();
        //test.start(new Car("Ford", "Focus", 115000f));
        //test.start(new Dog("гав-гав", "Бобик"));

        //Task2
        try {
            readClassesInFolder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readClassesInFolder() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, MalformedURLException
    {
        File folder = new File("E:/Java/ClassTest");
        String[] fileNames = folder.list();
        for (String fileName : fileNames) {
            if (!fileName.toLowerCase(Locale.ROOT).endsWith(".class")) {
                continue;
            }
            String className = fileName.substring(0, fileName.length() - 6);
            //Class cl = Class.forName(className);
            Class cl = URLClassLoader.newInstance(new URL[]{folder.toURL()}).loadClass(className);
            Class[] param = {String.class};
            Object ob = cl.getConstructor(param).newInstance("Павел");
            Method[] metodsDeclared = cl.getDeclaredMethods();
            for (Method m : metodsDeclared) {
                boolean check = false;
                if (m.getName().equalsIgnoreCase("getname")
                        || m.getName().equalsIgnoreCase("startapplication")
                        || m.getName().equalsIgnoreCase("closeapplication")
                        || m.getName().equalsIgnoreCase("beginwork")) {
                    check = true;
                }
                if (!check) {
                    continue;
                }

                if (m.isAccessible()) {
                    m.invoke(ob);
                } else {
                    m.setAccessible(true);
                    m.invoke(ob);
                }
            }
        }
    }
}
