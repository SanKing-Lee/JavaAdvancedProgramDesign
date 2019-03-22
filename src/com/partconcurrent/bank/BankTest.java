package com.partconcurrent.bank;

/**
 * Author: Sean
 * Date: Created In 19:05 2019/3/22
 * Title: 测试银行
 * Description: 调用多个线程进行转账，测试线程同步
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class BankTest {
    private static final int NTHREAD = 100;
    private static final int MAX_AMOUNT = 500;
    private static final int SLEEP_TIME = 10;

    public static void main(String[] args){
        Bank bank = new Bank();
        for(int i = 0; i < NTHREAD; i++){
            // 实现一个Runnable接口，定义一个线程
            int fromAccount = i;
            Runnable r = ()->{
              try{
                  while(true){
                      int toAccount = (int)(bank.size()*Math.random());
                      int amount = (int)(MAX_AMOUNT*Math.random());
                      bank.transfer(fromAccount, toAccount, amount);
                      Thread.sleep((int)(SLEEP_TIME*Math.random()));
                  }
              }
              catch (InterruptedException e){
                  e.printStackTrace();
              }
            };
            Thread t = new Thread(r);
            t.start();
        }

    }
}
