package com.partconcurrent.philosopher;

/**
 * Author:
 * Date: Created In 18:22 2019/4/28
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class PhilosopherThread extends Thread{
    private String name;
    private Chopsticks chopsticks;

    private static final int EATING_TIME = 1000;
    private static final int THINKING_TIME = 1000;

    public PhilosopherThread(String name, Chopsticks chopsticks){
        super(name);
        this.chopsticks = chopsticks;
    }

    public void eat(){
        try{
            System.out.println("Philosopher " + getName() + " start eating!");
            Thread.sleep(EATING_TIME);
        } catch(InterruptedException e){
            System.out.println("Eating was interrupted");
            e.printStackTrace();
        }
    }

    public void think(){
        try{
            System.out.println("Philosopher " + getName() + " start thinking!");
            Thread.sleep(THINKING_TIME);
        } catch (InterruptedException e){
            System.out.println("Thinking was interrupted");
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(true)
        {
            chopsticks.getChop();
            this.eat();
            chopsticks.freeChop();
            this.think();
        }
    }

    public Chopsticks getChopsticks() {
        return chopsticks;
    }

    public void setChopsticks(Chopsticks chopsticks) {
        this.chopsticks = chopsticks;
    }
}
