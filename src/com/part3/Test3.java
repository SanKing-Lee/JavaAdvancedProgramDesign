package com.part3;

import java.util.Scanner;

/**
 * Author:
 * Date: Created In 21:28 2019/4/5
 * Title:
 * Description:
 * Version:
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Test3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = 0;
        m = in.nextInt();
        int[] power = new int[m];
        int[] gold = new int[m];
        for(int i = 0; i < m; i++){
            power[i] = in.nextInt();
        }
        for(int i = 0; i < m; i++){
            gold[i] = in.nextInt();
        }
        int presentPower = power[0];
        int goldCount = gold[0];
    }
}
