package com.part2.settest;

/**
 * Author: Sean
 * Date: Created In 19:36 2019/3/17
 * Title: 学生类
 * Description: 用以描述学生的姓名、年龄等属性和方法的类
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Student {
    private String name;    //姓名
    private int age;        //年龄

    /**
     * 构造函数
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写hash函数
     *
     * @return 该对象的哈希码
     */
    @Override
    public int hashCode() {
        return 60;
    }

    /**
     * 重写比较函数
     *
     * @param o 与该对象进行比较的对象
     * @return 如果该对象与目标对象的姓名、年龄一致，则返回true，否则返回false
     */
    @Override
    public boolean equals(Object o) {
        // 如果该对象不是Student的实例类，则一定不相等，返回false
        if (!(o instanceof Student)) {
            return false;
        }
        // 将该Object转换为Student类的实例对象，比较姓名和年龄是否一致
        Student student = (Student) o;
        return this.name.equals(student.getName()) && this.age == student.getAge();
    }

    /**
     * 重写toString函数
     *
     * @return 描述学生类的String
     */
    @Override
    public String toString() {
        return "{name: " + this.name + ", age: " + this.age + "}";
    }
}
