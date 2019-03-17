package com.part2.settest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Author: Sean
 * Date: Created In 19:48 2019/3/17
 * Title: 测试HashSet
 * Description: 利用HashSet实现对学生信息的增删查改，熟悉HashSet的操作
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestHashSet {
    public static void hashSet1() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("java001");
        hashSet.add("java01");
        hashSet.add("java011");
        hashSet.add("java002");
        hashSet.add("java004");
        hashSet.add("java001");
        Iterator<String> ite = hashSet.iterator();
        while (ite.hasNext()) {
            String next = ite.next();
            Logger.getGlobal().info(next);
        }
    }

    public static void hashSet2() {
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(new Student("zhangsan", 18));
        hashSet.add(new Student("zhangsan", 18));
        hashSet.add(new Student("lisi", 20));
        hashSet.add(new Student("wanger", 21));
        Iterator<Student> ite = hashSet.iterator();
        while (ite.hasNext()) {
            Student student = ite.next();
            Logger.getGlobal().info(student.toString());
        }
    }

    public static void main(String[] args) {
        hashSet1();
        hashSet2();
    }
}
