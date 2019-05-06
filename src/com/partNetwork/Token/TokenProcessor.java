package com.partNetwork.Token;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Sean
 * Date: Created In 18:33 2019/5/3
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TokenProcessor {
    private TokenProcessor(){};
    private static final TokenProcessor instance = new TokenProcessor();
    private static final int BOUND = 99999999;

    public static TokenProcessor getInstance(){
        return instance;
    }

    public String createToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(BOUND))+"";
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            String code = encoder.encode(md5);
            String regEx = "[+%& /?#&=]";
            Pattern p = Pattern.compile(regEx);
            Matcher matcher = p.matcher(code);
            return matcher.replaceAll("").trim();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
}
