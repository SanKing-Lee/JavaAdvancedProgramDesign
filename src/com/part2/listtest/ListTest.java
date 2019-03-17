package com.part2.listtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

/**
 * Author: Sean
 * Date: Created In 17:09 2019/3/16
 * Title: 测试ArrayList
 * Description: 用ArrayList实现对用户的增、删、查、改
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] Wat has been done;
 */

public class ListTest {
    public static void main(String [] args){
        List<User> list = new ArrayList<User>();
        list.add(new User("小明", "xiaoming@qq.com"));
        list.add(new User("小张", "xiaozhang@qq.com"));
        User xiaohu = new User("小胡", "xiaohu@qq.com");
        list.add(xiaohu);

        ListIterator<User> ite = list.listIterator();
        System.out.println("方法1：");
        while(ite.hasNext()){
            User user = ite.next();
            System.out.println(user.toString());
        }
        System.out.println("方法2：");
        for(ListIterator<User> ite2 = list.listIterator(); ite2.hasNext();){
            User user = ite2.next();
            System.out.println(user.toString());
        }
        System.out.println("方法3：");
        for(User tUser:list){
            System.out.println(tUser.toString());
        }
        System.out.println("方法4：");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
}
