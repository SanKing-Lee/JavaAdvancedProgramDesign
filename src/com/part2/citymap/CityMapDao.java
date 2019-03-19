package com.part2.citymap;

import java.util.ArrayList;
import java.util.Set;

/**
 * Author: Sean
 * Date: Created In 22:01 2019/3/19
 * Title: 访问CityMap的各种方法
 * Description: 继承CityMap，并定义访问CitiesMap的各种方法
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CityMapDao extends CityMap {
    /**
     * 根据给定的省的名称获取对应的所有城市名称
     *
     * @param sProvince 给定的省名
     * @return 省名对应的所有城市列表
     */
    public static ArrayList<String> getCitiesByProvince(String sProvince) {
        return CitiesMap.get(sProvince);
    }

    /**
     * 获取所有的省
     *
     * @return 所有的省名列表
     */
    public static ArrayList<String> getProvinces() {
        ArrayList<String> alProvinces = new ArrayList<>();
        Set<String> ssProvinces = CitiesMap.keySet();
        for (String province : ssProvinces) {
            alProvinces.add(province);
        }
        return alProvinces;
    }
}
