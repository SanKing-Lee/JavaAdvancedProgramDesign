package com.part1.shape;

import static com.part1.shape.ShapeType.CIRCLE;

/**
 * Author: Sean
 * Date: Created In 21:06 2019/3/14
 * Title: Circle类
 * Description: 实现一个圆类，并定义它获得面积、周长的方法
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Circle extends Shape {
    private double radius;  //圆的半径
    private static int circleCount = 0;

    /**
     * 构造函数，根据半径构造一个圆
     *
     * @param radius 半径
     */
    public Circle(double radius) {
        this.radius = radius;
        super.setType(CIRCLE);
        super.setName("Circle" + (circleCount++));
    }

    /**
     * 计算圆的面积
     *
     * @return 圆的面积
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(2, radius);
    }

    /**
     * 计算圆的周长
     *
     * @return 返回圆的周长
     */
    @Override
    public double getGirth() {
        return Math.PI * radius * 2;
    }

    /**
     * 将圆的名称、周长、面积以字符串形式返回
     *
     * @return 名称、周长、面积字符串
     */
    @Override
    public String toString() {
        return getName() + ": {" + " Type: " + getType().toString() + ", Area: " + getArea()
                + ", Girth: " + getGirth();
    }
}
