package com.part3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Author:
 * Date: Created In 17:17 2019/4/5
 * Title:
 * Description:
 * Version:
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 0;
        int n = 0;
        m = in.nextInt();
        n = in.nextInt();
        int[] coins = new int[n];
        int count = 0;
        int minCount = 0;
        for(int i = 0; i < n; i++){
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);
        for(int i = 1; i < m; i++){
            count = minCount(i, coins, n-1);
            if(count > minCount){
                minCount = count;
            }
        }
        System.out.println(minCount);
    }

    private static int minCount(int m, int[] coins, int k){
        if (k == 0) {
            if(m%coins[k] != 0){
                return -1;
            }
            return m/coins[k];
        }
        if(m < coins[k]){
            return minCount(m, coins, k-1);
        }
        return Math.min(minCount(m, coins, k-1), 1 + minCount(m - coins[k], coins, k - 1));
    }
}
