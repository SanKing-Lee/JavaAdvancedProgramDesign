package com.partconcurrent.philosopher;

/**
 * Author:
 * Date: Created In 18:23 2019/4/28
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestPhilosopher {
    private static final int PHILOSOPHER_NUM = 5;
    public static void main(String[] args){
        Chopsticks chopsticks = new Chopsticks();
        for(int i = 0; i < PHILOSOPHER_NUM; i++){
            PhilosopherThread philosopherThread = new PhilosopherThread(String.format("%d", i), chopsticks);
            philosopherThread.start();
        }
    }
}
