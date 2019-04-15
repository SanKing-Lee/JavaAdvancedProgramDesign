package com.part3;

import java.util.Scanner;

/**
 * Author:
 * Date: Created In 20:50 2019/4/5
 * Title:
 * Description:
 * Version:
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Test2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();
        String str = in.next();
        boolean flag = true;
        while(flag){
            flag = false;
            int len = str.length();
            for(int i = 0; i < len-1; i++){
                if(str.charAt(i) !=  str.charAt(i+1)){
                    if(i == 0 && i+1 == len-1){
                        str = "";
                    }
                    else if(i+1 == len-1){
                        str = str.substring(0, i);
                    }
                    else if(i == 0){
                        str = str.substring(i+2, len);
                    }
                    else {
                        str = str.substring(0, i) + str.substring(i + 2, len);
                    }
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(str.length());
    }
}
