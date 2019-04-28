package com.partconcurrent.philosopher;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 18:00 2019/4/28
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Chopsticks {
    static final int CHOPS_NUM = 5;
    static List<Boolean> chops = new ArrayList<>();
    static{
        for(int i = 0; i < CHOPS_NUM; i++){
            chops.add(false);
        }
    }

    synchronized void getChop(){
        String name = Thread.currentThread().getName();
        int index = Integer.valueOf(name);
        // 如果有任意一只筷子是true即被占用的情况，那就得让该线程等待
        while(chops.get(index) || chops.get((index+1)%CHOPS_NUM)){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Getting chops is interrupted");
                e.printStackTrace();
            }
        }
        // 获得了两只筷子
        chops.set(index, true);
        chops.set((index+1)%CHOPS_NUM, true);
        System.out.println("Philosopher " + name +
                " get " + index + " and " + (index+1)%CHOPS_NUM + " chopstick");
    }

    synchronized void freeChop(){
        String name = Thread.currentThread().getName();
        int index = Integer.valueOf(name);
        chops.set(index, false);
        chops.set((index+1)%CHOPS_NUM, false);
        notifyAll();
        System.out.println("Philosopher " + name + " put down " +
                index + " and " + (index+1)%CHOPS_NUM + " chopstick");
    }
}