package com.part2.citymap;

import java.io.*;
import java.util.*;

/**
 * Author: Sean
 * Date: Created In 20:43 2019/3/19
 * Title: 城市映射图
 * Description: 将全国各地的省市存储在一个map中
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CityMap {
    private static Map<String, ArrayList<String>> CitiesMap = new LinkedHashMap<>();

    static {
        readCities();
    }

    /**
     * 将Cities.txt里面存储的所有城市导入到CitiesMap中
     */
    private static void readCities() {
        // 获取文件
        File file = new File
                ("E:\\IntelliJProject\\JavaAdvancedProgramDesign\\src\\com\\part2\\citymap/Cities.txt");
        try {
            // 初始化文件读取器
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            String line = new String();
            // 按行读取文件中的数据
            while ((line = in.readLine()) != null) {
                // 按照空格分割字符串，第一个为省，后面的为市
                String[] sCities = line.split(" ");
                ArrayList<String> lCities = new ArrayList<String>();
                // 将所有的城市添加到list中
                for (String city : sCities) {
                    lCities.add(city);
                }
                // 获取省名称
                String sProvince = new String(lCities.get(0));
                // 将已经获取到了的省名称从城市中删除
                lCities.remove(0);
                // 添加到map中
                CitiesMap.put(sProvince, lCities);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出map中的所有城市
     */
    public static void printCities() {
        CitiesMap.forEach((province, cities) -> {
            System.out.println("Province: " + province + ", Cities: " + cities.toString());
        });
    }

    /**
     * 根据给定的省的名称获取对应的所有城市名称
     *
     * @param sProvince 给定的省名
     * @return 省名对应的所有城市列表
     */
    public static String[] getCitiesByProvince(String sProvince) {
        String[] res = new String[CitiesMap.get(sProvince).size()];
        return CitiesMap.get(sProvince).toArray(res);
    }

    /**
     * 获取所有的省
     *
     * @return 所有的省名列表
     */
    public static String[] getProvinces() {
        Set<String> ssProvinces = CitiesMap.keySet();
        String[] sProvinces = new String[ssProvinces.size()];
        ssProvinces.toArray(sProvinces);
        return sProvinces;
    }
}
