package com.part2.listtest;

/**
 * Author: Sean
 * Date: Created In 15:01 2019/3/16
 * Title: 用户信息类
 * Description: 用来表示用户的实体类，包含了姓名、电子邮件地址的属性
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class User {
    String name;    //姓名
    String email;   //电子邮件

    /**
     * 构造函数
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
