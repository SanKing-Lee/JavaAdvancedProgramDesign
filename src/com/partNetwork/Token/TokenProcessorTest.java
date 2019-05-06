package com.partNetwork.Token;

/**
 * Author: Sean
 * Date: Created In 18:39 2019/5/3
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TokenProcessorTest {
    public static void main(String[] args){
        TokenProcessor tokenProcessor = TokenProcessor.getInstance();
        System.out.println(tokenProcessor.createToken());
    }
}
