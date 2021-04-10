package ru.geekbrains.java3_work6_Reflection_Annotation;

import ru.geekbrains.java3_work6_Reflection_Annotation.Annotation.BeforeSuite;
import ru.geekbrains.java3_work6_Reflection_Annotation.Annotation.Test;

public class Dog {
    private String voice;
    private String name;

    public Dog(String voice, String name)
    {
        this.voice = voice;
        this.name = name;
    }

    public String getVoice()
    {
        return voice;
    }

    public String getName()
    {
        return name;
    }

    @BeforeSuite
    public void voice(){
        System.out.println(voice);
    }
    @Test
    public void run(){
        System.out.println("Собака " + name + " побежала.");
    }

}
