package com.part3.reflect.car;

/**
 * Author: Sean
 * Date: Created In 20:35 2019/4/15
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CarFactory {
    public Object getCar(String carName){
        try{
            Class cls = Class.forName(carName);
            return cls.newInstance();
        }catch (ClassNotFoundException e){
            System.out.println("这种车还没有开始生产");
        }catch(InstantiationException e){
            System.out.println("生产车出问题啦");
        }catch(IllegalAccessException e){
            System.out.println("生产车出问题啦");
            e.printStackTrace();
        }
        return null;
    }
}
