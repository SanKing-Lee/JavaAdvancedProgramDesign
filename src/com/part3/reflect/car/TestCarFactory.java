package com.part3.reflect.car;

/**
 * Author: Sean
 * Date: Created In 20:39 2019/4/15
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestCarFactory {
    public static void main(String[] args){
        CarFactory carFactory = new CarFactory();
        Car car = (Car)carFactory.getCar("com.part3.reflect.car.Bike");
        car.drive();
    }
}
