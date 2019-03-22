package com.partconcurrent.bank;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Sean
 * Date: Created In 18:44 2019/3/22
 * Title: 银行的多线程转账
 * Description: 维护一系列的账号，多个线程同时进行转账的操作，给线程加锁来进行同步，加入条件对象来防止转账条件一直无法满足
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Bank {
    private double[] accounts;
    private final int ACCOUNT_NUM= 100;
    private final int DEFAULT_BALANCE = 1000;
    private ReentrantLock banklock;
    private Condition sufficientBalance;

    /**
     * 构造函数，注册一百个账户并在其中加入余额并初始化锁和条件对象
     */
    public Bank(){
        accounts = new double[ACCOUNT_NUM];
        Arrays.fill(accounts, DEFAULT_BALANCE);
        banklock = new ReentrantLock();
        sufficientBalance = banklock.newCondition();
    }

    /**
     * 进行转账操作，对线程进行加锁，在测试账户余额是否充足部分加上条件对象并在转账完成后调用signalAll
     * @param from      转出的账户
     * @param to        转入的账户
     * @param amount    转账的金额
     * @throws InterruptedException 转账线程中可能出现的异常
     */
    public void transfer(int from, int to, int amount) throws InterruptedException{
        // 给当前的交易加锁
         banklock.lock();
        try{
             // 如果账户内的余额不足，则调用await将当前线程放入等待集中
            while(accounts[from] < amount){
                sufficientBalance.await();
            }
            // 输出当前线程
            System.out.print(Thread.currentThread());
            // 转账
            accounts[from] -= amount;
            System.out.println(amount + " from " + from + " to " + to);
            accounts[to] += amount;
            // 获取余额
            System.out.println("Total Balance: " + getBalance());
            // 通知因余额不足而加入等待集的线程
            sufficientBalance.signalAll();
        }
        finally {
            // 释放锁
            banklock.unlock();
        }
    }

    /**
     * 获取所有账户里的余额，如果线程同步出现了错误，则余额总额将会发生变化，否则将会一直保持不变
     * @return  所有账户里的余额之和
     */
    public double getBalance(){
        double sum = 0;
        // 加锁
        banklock.lock();
        try{
            // 遍历求和
            for(double bal : accounts){
                sum+= bal;
            }
            return sum;
        }
        finally {
            // 释放锁
            banklock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
}