package com.part1.employee.manager;


import com.part1.employee.employee.Employee;

/**
 * Author: Sean
 * Date: Created In 16:34 2019/3/14
 * Title: Manager
 * Description: Manager extend from Employee
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What is done;
 */

public class Manager extends Employee {
    private double basewages = 3000;    //基本工资
    private String department;          //部门
    private String position;            //职位

    /**
     * constructor
     */
    public Manager(String ID, String name, String department, String position) {
        super(ID, name);
        this.department = department;
        this.position = position;
    }

    @Override
    public double calculateCount(int workDays, int overtimeDays, int absentDays) {
        double count = basewages + 20 * overtimeDays - 30 * absentDays;
        salary = count;
        return count;
    }

    /**
     * transform to String
     */
    public String toString() {
        return name + ": " + salary + "\n";
    }
}
