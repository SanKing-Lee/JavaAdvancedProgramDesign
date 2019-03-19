package com.part2.citymap;

import java.util.ArrayList;

/**
 * Author: Sean
 * Date: Created In 21:52 2019/3/19
 * Title: 测试城市录入
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestInputFrame {
    public static void main(String[] args) {
        ArrayList<String> provinces = CityMapDao.getProvinces();
        ArrayList<String> cities = CityMapDao.getCitiesByProvince("四川");
        System.out.println(provinces.toString());
        System.out.println(cities.toString());
    }
}
