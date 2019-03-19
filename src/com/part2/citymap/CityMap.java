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
    protected static Map<String, ArrayList<String>> CitiesMap = new LinkedHashMap<>();
    static{
        readCities();
        printCities();
    }
    private static final void readCities(){
        File file = new File("E:\\IntelliJProject\\JavaAdvancedProgramDesign\\src\\com\\part2\\citymap/Cities.txt");
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            String line = new String();
            while((line = in.readLine()) != null){
               String[] sCities = line.split(" ");
               ArrayList<String> lCities = new ArrayList<String>();
               for(String city : sCities){
                   lCities.add(city);
               }
               String sProvince = new String(lCities.get(0));
               lCities.remove(0);
               CitiesMap.put(sProvince, lCities);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static final void printCities(){
        CitiesMap.forEach((province, cities)->{
            System.out.println("Province: " + province + ", Cities: " + cities.toString());
        });
    }
}
