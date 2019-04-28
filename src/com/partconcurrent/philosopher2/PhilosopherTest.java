package com.partconcurrent.philosopher2;

/**
 * Author: Sean
 * Date: Created In 23:05 2019/4/28
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class PhilosopherTest {
    private static final int PHILOSOPHER_NUM = 5;

    public static void main(String[] args) {
        Philosopher philosopher = new Philosopher();
        for (int i = 0; i < PHILOSOPHER_NUM; i++) {
            int philosopherId = i;
            Runnable r = () -> {
                while (true) {
                    philosopher.getChop(philosopherId);
                    philosopher.eat(philosopherId);
                    philosopher.freeChop(philosopherId);
                    philosopher.think(philosopherId);
                }
            };
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
