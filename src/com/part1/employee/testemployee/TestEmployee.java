package com.part1.employee.testemployee;


import com.part1.employee.manager.Manager;
import com.part1.employee.staff.Staff;

/**
 * Author: Sean
 * Date: Created In 15:53 2019/3/14
 * Title: TestEmployee
 * Description: test the project employee
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What is done;
 */

public class TestEmployee {
    public static void main(String[] args) {
        Manager manager = new Manager("001", "张三", "开发部", "经理");
        manager.calculateCount(22, 3, 0);
        System.out.print(manager.toString());

        Staff staff = new Staff("2002", "李四", "财务部", "会计");
        staff.calculateCount(20, 6, 1);
        System.out.println(staff.toString());
    }
}
