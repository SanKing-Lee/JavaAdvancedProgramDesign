package com.part3.reflect.car;

/**
 * Author: Sean
 * Date: Created In 20:33 2019/4/15
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Bike implements Car {
    @Override
    public void drive(){
        System.out.println("骑自行车");
    }
}
