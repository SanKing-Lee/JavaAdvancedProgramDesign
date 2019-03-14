package com.part1.employee.staff;


import com.part1.employee.employee.Employee;

/**
 * Author: Sean
 * Date: Created In 16:24 2019/3/14
 * Title: Staff
 * Description: Staff extend from employee
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What is done;
 */

public class Staff extends Employee {
    private double baseWage = 2000; //基本工资
    private double dailyWage = 50;  //日工资
    private String department;      //部门
    private String title;           //职称

    /**
     * constructor
     */
    public Staff(String ID, String name, String department, String title) {
        super(ID, name);
        this.department = department;
        this.title = title;
    }

    @Override
    public double calculateCount(int workDays, int overtimeDays, int absentDays) {
        double count = baseWage + dailyWage * workDays + dailyWage * overtimeDays - dailyWage * absentDays;
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
