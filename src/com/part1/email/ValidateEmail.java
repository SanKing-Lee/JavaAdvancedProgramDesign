package com.part1.email;

import java.util.logging.Logger;

/**
 * Author: Sean
 * Date: Created In 18:18 2019/3/14
 * Title: 验证邮箱
 * Description: 验证邮箱地址
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ValidateEmail {
    /**
     * 检验一个邮件地址是否规范
     *
     * @param sPara 邮件地址
     * @return 如果规范，返回true，否则返回false
     */
    public static boolean isEmail(String sPara) {
        //如果邮箱地址为空,返回false
        if (sPara == null || sPara.equals(" ")) {
            return false;
        }
        //邮箱地址中@的位置
        int indexOfAt = sPara.indexOf('@');
        //邮件地址中没有@，邮件地址不规范
        if (indexOfAt == -1) {
            return false;
        }
        //如果第一个@的位置和第二个@的位置不一样，说明至少有两个@，邮件地址不规范
        if (indexOfAt != sPara.lastIndexOf('@')) {
            return false;
        }
        //如果邮箱地址中不包含'.'，邮箱地址不规范
        if (sPara.indexOf('.') == -1) {
            return false;
        }
        //获取邮箱地址@前面的username部分
        String userName = sPara.substring(0, indexOfAt);
        //获取邮箱地址@后面的domain部分
        String domain = sPara.substring(indexOfAt + 1);
        //检测username部分是否全为字母或数字
        for (int i = 0; i < userName.length(); i++) {
            char tChar = userName.charAt(i);
            //如果不是字母和数字，返回false
            if (!Character.isAlphabetic(tChar) && !Character.isDigit(tChar)) {
                return false;
            }
        }
        //检测domain部分是否全为字母或数字和'.',而且不能以'.'开头和以'.'结尾
        //以'.'开头或结尾，返回false
        if (domain.charAt(0) == '.' || domain.charAt(domain.length() - 1) == '.') {
            return false;
        }
        //是否全为字母或数字
        for (int i = 0; i < domain.length(); i++) {
            char tChar = domain.charAt(i);
            //如果不是字母或数字或'.'，返回false
            if (!Character.isAlphabetic(tChar) && !Character.isDigit(tChar) && !(tChar == '.')) {
                return false;
            }
        }
        return true;
    }
}
