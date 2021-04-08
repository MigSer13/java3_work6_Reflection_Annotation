package ru.geekbrains.java3_work6_Reflection_Annotation;

import ru.geekbrains.java3_work6_Reflection_Annotation.Annotation.*;

public class Car {
    private String brand;
    private String model;
    private float odometer;

    public Car(String brand, String model, float odometer)
    {
        this.brand = brand;
        this.model = model;
        this.odometer = odometer;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public float getOdometer()
    {
        return odometer;
    }
    @Test(priority = 8)
    public void drive() {
        System.out.println("Машина "+brand+"-"+model+" поехала. (Test_8)");
    }
    @Test(priority = 3)
    public void openDoor() {
        System.out.println("В "+brand+"-"+model+" открыта дверь. (Test_3)");
    }
    @Test()
    public void closeDoor() {
        System.out.println("В "+brand+"-"+model+" закрыта дверь.(Test_default)");
    }

    @BeforeSuite
    public void startEngine(){
        System.out.println("Двигатель "+brand+"-"+model+" завелся. (BeforeSuite)");
    }
    @AfterSuite
    public void turnOffEngine(){
        System.out.println("Двигатель "+brand+"-"+model+" заглушен. (AfterSuite)");
    }

}
