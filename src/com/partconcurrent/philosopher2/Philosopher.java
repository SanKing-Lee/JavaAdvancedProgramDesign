package com.partconcurrent.philosopher2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 22:53 2019/4/28
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Philosopher {
    private static final int CHOP_NUM = 5;          // 筷子的数量
    private static final int EATING_TIME = 1000;    // 哲学家吃饭的时间
    private static final int THINKING_TIME = 4000; // 哲学家思考的时间

    private List<Boolean> chopsticks = new ArrayList<>(CHOP_NUM);

    public Philosopher(){
        for(int i = 0;  i < CHOP_NUM; i++){
            chopsticks.add(false);
        }
    }

    synchronized public void getChop(int philosopherId){
        int left = philosopherId;
        int right = (philosopherId+1)%CHOP_NUM;
        while (chopsticks.get(left) || chopsticks.get(right)) {
            try{
                wait();
            } catch(InterruptedException e){
                System.out.println("Getting chopsticks lock was interrupted");
                e.printStackTrace();
            }
        }
        chopsticks.set(left, true);
        chopsticks.set(right, true);
        System.out.println("Philosopher " + philosopherId + " gets " + left + " and " + right + " chopsticks");
    }

    synchronized public void freeChop(int philosopherId){
        int left = philosopherId;
        int right = (philosopherId+1)%CHOP_NUM;

        chopsticks.set(left, false);
        chopsticks.set(right, false);
        notifyAll();
        System.out.println("Philosopher " + philosopherId + " puts down " + left + " and " + right + " chopsticks");
    }

    public void eat(int philosopherId){
        try{
            System.out.println("Philosopher " + philosopherId + " start eating!");
            Thread.sleep(EATING_TIME);
        } catch (InterruptedException e){
            System.out.println("Philosopher " + philosopherId + " eating was interrupted!");
            e.printStackTrace();
        }
    }

    public void think(int philosopherId){
        try{
            System.out.println("Philosopher " + philosopherId + " start thinking!");
            Thread.sleep(THINKING_TIME);
        } catch (InterruptedException e){
            System.out.println("Philosopher " + philosopherId + " thinking was interrupted!");
            e.printStackTrace();
        }
    }
}

