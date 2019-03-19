package com.part2.maptest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Author: Sean
 * Date: Created In 21:29 2019/3/17
 * Title: 测试Map类
 * Description: 将学生类存入Map类中并对其进行增删改查，熟悉HashMap操作
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestMap {
    private Map<String, Student> student;

    /**
     * 构造函数，生成一个存储学生信息的Map
     */
    public TestMap(){
        this.student = new HashMap<String, Student>();
    }

    /**
     * 从输入流读取学生信息并存储在student Map中，测试HashMap的put操作
     */
    public void testPut(){
        // 创建Scanner对象，输入学生ID
        Scanner sc = new Scanner(System.in);
        int i = 0;
        // 读取三个学生信息并存储
        while(i < 3){
            // 获得学生ID
            System.out.println("请输入学生ID：");
            String stuID = sc.next();
            // 在student查找这个ID是否被占用，如果被占用则进行else，否则继续输入姓名并存储该学生信息
            Student stu = student.get(stuID);
            if(stu == null){
                // 获取学生姓名
                System.out.println("请输入学生姓名：");
                String stuName = sc.next();
                // 根据获得的学生信息初始化一个学生并存储到student中
                Student newStudent = new Student(stuID, stuName);
                student.put(stuID, newStudent);
                System.out.println("成功添加学生：" + newStudent.toString());
                i++;
            }
            else{
                System.out.println("该学生ID已被占用！");
                continue;
            }
        }
    }

    /**
     * 测试Map的keySet方法
     */
    public void testKeySet(){
        // 获取keySet和keySet的大小并输出
        Set<String> keySet = student.keySet();
        System.out.println("总共有" + keySet.size() + "名学生");
        // 利用lamda表达式对keySet中的所有元素进行遍历查找到相应的学生对象并输出
        keySet.forEach((String id)->{
            Student stu = student.get(id);
            System.out.println(stu.toString());
        });
    }

    /**
     * 测试hashMap中的EntrySet方法，对student中的学生信息进行遍历并输出
     */
    public void testEntrySet(){
        Set<Map.Entry<String, Student>> entrySet = student.entrySet();
        System.out.println("总共有" + entrySet.size() + "名学生");
        for(Map.Entry<String, Student> entry:entrySet){
            Student stu = entry.getValue();
            System.out.println(stu.toString());
        }
    }

    /**
     * 测试hashMap的forEach方法，对student中的所有元素进行遍历并输出学生信息
     */
    public void testForEach(){
        System.out.println("总共有: " + student.size() + "名学生");
        student.forEach((String id, Student stu)->{
           System.out.println(stu.toString());
        });
    }

    public void tesetRemove(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("请输入需要删除的学生的学号: ");
            String id = in.next();
            Student stu = student.get(id);
            if(stu == null){
                System.out.println("该学生不存在，请重新输入学号！");
                continue;
            }
            student.remove(id);
            System.out.println("成功删除学生：" + stu.toString());
            break;
        }
    }

    /**
     * 测试hashMap的更新方法，利用put将指定学生替换为新的学生
     */
    public void testModify(){
        System.out.println("请输入需要替换学生的ID：");
        while(true){
            Scanner in = new Scanner(System.in);
            String id = in.next();
            Student stu = student.get(id);
            if(stu == null){
                System.out.println("该学生不存在，请重新输入！");
                continue;
            }
            System.out.println("当前修改的学生为：" + stu.toString());
            System.out.println("请输入新学生的姓名：");
            String newName = in.next();
            Student newStu = new Student(id, newName);
            student.put(id, newStu);
            System.out.println("修改学生信息成功，修改后的学生信息为:" + student.get(id).toString());
            break;
        }
    }

    /**
     * 利用merge的方法对学生信息map进行更新
     */
    public void testMerge(){
        System.out.println("请输入需要替换学生的ID：");
        while(true){
            Scanner in = new Scanner(System.in);
            String id = in.next();
            Student stu = student.get(id);
            if(stu == null){
                System.out.println("该学生不存在，请重新输入！");
                continue;
            }
            System.out.println("当前修改的学生为：" + stu.toString());
            System.out.println("请输入新学生的姓名：");
            String newName = in.next();
            Student newStu = new Student(id, newName);
            student.merge(id, newStu, (stu1, stu2)->{
               return stu2;
            });
            System.out.println("修改学生信息成功，修改后的学生信息为:" + student.get(id).toString());
            break;
        }
    }

    public static void main(String[] args){
        TestMap tM = new TestMap();
        tM.testPut();
        tM.testForEach();
        tM.testModify();
        tM.testMerge();
        tM.testForEach();
    }
}
