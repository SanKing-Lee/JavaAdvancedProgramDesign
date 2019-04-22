package com.part3.reflect.point;

/**
 * Author: Sean
 * Date: Created In 21:34 2019/4/15
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Point {
    private int x;
    private int y;
    private String name;

    /**
     * 无参构造函数
     */
    public Point() {

    }

    /**
     * 带x的构造函数
     *
     * @param x 横坐标
     */
    public Point(int x) {
        this.x = x;
    }

    /**
     * 带x和y的构造函数
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 带所有参数的构造函数
     *
     * @param x    横坐标
     * @param y    纵坐标
     * @param name 名称
     */
    public Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * 移动点
     *
     * @param dx   水平偏移分量
     * @param dy   垂直偏移分量
     * @param name 新的名称
     */
    public void move(int dx, int dy, String name) {
        x += dx;
        y += dy;
        this.name = name;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 31;
        result = prime * result + 31;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return (x == other.getX() && y == other.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "x: " + x + ", y: " + y + ", name: " + name;
    }
}
