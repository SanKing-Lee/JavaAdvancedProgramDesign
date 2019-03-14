package com.part1.shape;

/**
 * Author: Sean
 * Date: Created In 20:58 2019/3/14
 * Title: 抽象类Shape
 * Description: 创建Shape基类供Circle和Rectangle继承
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public abstract class Shape {
    private ShapeType type;    //类型
    private String name;    //名称
    private double area;    //面积
    private double girth;   //周长

    /**
     * 获得几何图形的类型
     *
     * @return 名称
     */
    public ShapeType getType() {
        return type;
    }

    /**
     * 设置几何图形的类型
     *
     * @param type ShapeType类型的枚举
     */
    public void setType(ShapeType type) {
        this.type = type;
    }

    /**
     * 抽象方法，不同的几何图形有不同的计算面积的方法
     *
     * @return 面积
     */
    public abstract double getArea();

    /**
     * 抽象方法，不同的几何图形有不同的计算周长的方法
     *
     * @return
     */
    public abstract double getGirth();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
