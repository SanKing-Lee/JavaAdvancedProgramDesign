package com.part2.maptest;

/**
 * Author: Sean
 * Date: Created In 21:25 2019/3/17
 * Title: 学生类
 * Description: 用以描述学生信息的类
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Student {
    private String id;
    private String name;

    /**
     * 构造函数
     * @param id    //序号
     * @param name  //姓名
     */
    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * 对equals方法的重写，如果Object是一个空指针，则返回false，否则返回id和name的比较结果
     * @param o 传入进行比较的对象
     * @return  如果相同则返回true，否则返回false
     */
    @Override
    public boolean equals(Object o){
        Student obj = (Student)o;
        if(o == null){
            return false;
        }
        else{
            return this.id.equals(obj.id) && this.name.equals(obj.name);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "{id: " + id + ", name: " + name + "}";
    }
}
