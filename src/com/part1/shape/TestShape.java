package com.part1.shape;

import java.util.logging.Logger;

/**
 * Author: Sean
 * Date: Created In 21:17 2019/3/14
 * Title: 测试Shape
 * Description: 测试Circle类和Rectangle类
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestShape {
    public static void main(String[] args) {
        //圆形类
        Circle circle0 = new Circle(2);
        Logger.getGlobal().info(circle0.toString());
        Circle circle1 = new Circle(5);
        Logger.getGlobal().info(circle1.toString());

        //矩形类
        Rectangle rectangle0 = new Rectangle(3, 4);
        Logger.getGlobal().info(rectangle0.toString());
        Rectangle rectangle1 = new Rectangle(10, 20);
        Logger.getGlobal().info(rectangle1.toString());
    }
}
