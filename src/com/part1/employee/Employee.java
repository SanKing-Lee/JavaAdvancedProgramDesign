package com.part1.employee;

/**
 * Author: Sean
 * Date: Created In 16:10 2019/3/14
 * Title: Employee
 * Description: Describe employees' information and operation
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What is done;
 */

public class Employee {
    private String ID;
    protected String name;

    int workDays; // 工作天数
    int overtimeDays; // 加班天数
    int absentDays; // 缺勤天数
    protected double salary; // 工资

    /**
     * constructor with ID
     */
    public Employee(String ID) {
        this.ID = ID;
    }

    /**
     * constructor with ID & name
     */
    public Employee(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /**
     * calculate salary
     *
     * @param workDays     实工作天数
     * @param overtimeDays 实加班天数
     * @param absentDays   实缺勤天数
     * @return 工资
     */
    public double calculateCount(int workDays, int overtimeDays, int absentDays) {
        return 80 * workDays + 80 * overtimeDays - 30 * absentDays;
    }

    /**
     * transform to String
     *
     * @return String for salary
     */
    public String toString() {
        return name + ": " + salary;
    }
}
