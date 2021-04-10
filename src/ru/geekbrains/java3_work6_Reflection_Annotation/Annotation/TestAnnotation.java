package ru.geekbrains.java3_work6_Reflection_Annotation.Annotation;

import javafx.application.Application;
import ru.geekbrains.java3_work6_Reflection_Annotation.Car;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.CacheRequest;
import java.security.Policy;
import java.util.Set;
import java.util.TreeSet;

public class TestAnnotation {
    private Set<String> set = new TreeSet<String>();

    public void start(Object ob) throws IllegalAccessException, InstantiationException
    {
        Class testClass = ob.getClass();
        Method[] metods = testClass.getMethods();

        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        for(Method m : metods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                countBeforeSuite++;
                if(countBeforeSuite > 1){
                    throw new RuntimeException("@BeforeSuite > 1. There must be one annotation.");
                }
                set.add("0_" + m.getName());
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                countAfterSuite++;
                if(countAfterSuite > 1){
                    throw new RuntimeException("@AfterSuite > 1. There must be one annotation.");
                }
                set.add("999_" + m.getName());
            }
            if(m.isAnnotationPresent(Test.class)){
                Test test = m.getAnnotation(Test.class);
                int priority = test.priority();
                set.add(priority + "_" + m.getName());
            }
        }

        int indexBegin;
        for(String s : set){
            indexBegin = s.indexOf('_')+1;
            try {
                Method m = testClass.getMethod(s.substring(indexBegin));
                m.invoke(ob);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }
}
