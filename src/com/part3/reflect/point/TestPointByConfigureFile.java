package com.part3.reflect.point;

import jdk.management.resource.ResourceContext;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Author: Sean
 * Date: Created In 21:44 2019/4/15
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TestPointByConfigureFile {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("com/part3/reflect/point/config.properties");
        try {
            if(inputStream == null){
                System.out.println("null input stream");
            }
            else {
                properties.load(new InputStreamReader
                        (inputStream, StandardCharsets.UTF_8));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        String sClassname = properties.getProperty("classname");
        String[] sArgs = properties.getProperty("args").split(",");
        String[] sArgsType = properties.getProperty("argsType").split(",");
        String sMethod = properties.getProperty("method");
        System.out.println(sClassname);
        System.out.println(Arrays.toString(sArgs));
        System.out.println(Arrays.toString(sArgsType));
        System.out.println(sMethod);
        for(int i = 0; i < sArgsType.length; i++){
            System.out.println(getPrimitiveClass(sArgsType[i]).getName());
        }
    }
    private static Class getPrimitiveClass(String str){
        str = str.toLowerCase();
        switch(str){
            case "int": return java.lang.Integer.class;
            case "double": return java.lang.Double.class;
            case "float": return java.lang.Float.class;
            case "char": return java.lang.Character.class;
            case "string": return java.lang.String.class;
            default:
                System.out.println("undefined!");
                return Object.class;
        }
    }
}
