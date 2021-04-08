package ru.geekbrains.java3_work6_Reflection_Annotation;

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

    private void voice(){
        System.out.println(voice);
    }
    public void run(){
        System.out.println("Собака " + name + " побежада.");
    }

}
