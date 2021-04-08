package ru.geekbrains.java3_work6_Reflection_Annotation;

import ru.geekbrains.java3_work6_Reflection_Annotation.Annotation.TestAnnotation;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        TestAnnotation test = new TestAnnotation();
        test.start(new Car("Ford", "Focus", 115000f));
    }
}
