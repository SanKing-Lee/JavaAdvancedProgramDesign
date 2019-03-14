package com.part1.shape;

import static com.part1.shape.ShapeType.RECTANGLE;

/**
 * Author: Sean
 * Date: Created In 21:12 2019/3/14
 * Title: Rectangle类
 * Description: 实现一个继承了Shape的矩形类，并定义它计算面积、周长的方法
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Rectangle extends Shape {
    private double length;  //长
    private double width;   //宽
    private static int rectangleCount = 0;

    /**
     * 构造函数
     *
     * @param length 长
     * @param width  宽
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        super.setName("Rectangle" + (rectangleCount++));
        super.setType(RECTANGLE);
    }

    /**
     * 计算面积，长乘宽
     *
     * @return 返回矩形面积
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * 计算周长，（长+宽）*2
     *
     * @return 返回矩形周长
     */
    @Override
    public double getGirth() {
        return (length + width) * 2;
    }

    /**
     * 用于输出矩形的名称、类型、面积和周长
     *
     * @return 矩形的名称、类型、面积和周长的字符串
     */
    @Override
    public String toString() {
        return getName() + ": {" + " Type: " + getType().toString() + ", Area: " + getArea()
                + ", Girth: " + getGirth();
    }
}
