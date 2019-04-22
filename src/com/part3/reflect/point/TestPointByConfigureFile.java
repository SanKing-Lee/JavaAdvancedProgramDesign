package com.part3.reflect.point;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

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
        // 读取properties文件
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("com/part3/reflect/point/config.properties");
        try {
            if (inputStream == null) {
                System.out.println("null input stream");
            } else {
                properties.load(new InputStreamReader
                        (inputStream, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            System.out.println("读取properties文件出错！");
            e.printStackTrace();
        }

        // 从properties文件中读取相应的属性
        String sClassname = properties.getProperty("classname");
        String[] sArgs = properties.getProperty("args").split(",");
        String[] sArgsType = properties.getProperty("argsType").split(",");
        String sMethod = properties.getProperty("method");

        // 输出检验
        System.out.println(sClassname);
        System.out.println(Arrays.toString(sArgs));
        System.out.println(Arrays.toString(sArgsType));
        System.out.println(sMethod);

        // 根据获取到的参数类型字符串列表转换为相应的Class列表
        Class[] oArgsType = new Class[sArgsType.length];
        for (int i = 0; i < sArgsType.length; i++) {
            oArgsType[i] = getPrimitiveClass(sArgsType[i]);
            System.out.println(oArgsType[i].getName());
        }

        // 根据参数类型列表将参数转换为相应的类型
        Object[] oArgs = new Object[sArgs.length];
        for (int i = 0; i < sArgs.length; i++) {
            oArgs[i] = transferArguments(sArgsType[i], sArgs[i]);
            System.out.println(oArgs[i]);
        }

        // 根据类名获得它的Class
        Class newClass = null;
        try {
            newClass = Class.forName(sClassname);
        } catch (ClassNotFoundException e) {
            System.out.println("根据类名初始化类出错！");
            System.exit(0);
        }
        if (newClass == null) {
            System.out.println("类指针为空");
            System.exit(0);
        }

        // 根据方法名获取method
        Method method = null;
        try {
            method = newClass.getMethod(sMethod, oArgsType);
        } catch (NoSuchMethodException e) {
            System.out.println("未找到该方法！");
            System.exit(0);
        }

        // 实例化一个对象并对它进行方法调用
        Object p = null;
        if (method != null) {
            try {
                p = newClass.newInstance();
                method.invoke(p, oArgs);
            } catch (IllegalAccessException | InstantiationException e) {
                System.out.println("生成新实例出错！");
                System.exit(0);
            } catch (InvocationTargetException e) {
                System.out.println("调用方法出错！");
                System.exit(0);
            }
        }
        if (p != null) {
            System.out.println(p.toString());
        }
    }

    /**
     * 根据字符串获取基本类型的class
     *
     * @param str 基本类型的名称
     * @return 基本类型对应的Class
     */
    private static Class getPrimitiveClass(String str) {
        str = str.toLowerCase();
        switch (str) {
            case "int":
                return int.class;
            case "double":
                return double.class;
            case "float":
                return float.class;
            case "char":
                return char.class;
            case "string":
                return String.class;
            default:
                System.out.println("undefined!");
                return Object.class;
        }
    }

    /**
     * 根据type将Value转换为相应类型的数据
     *
     * @param type  数据类型
     * @param value 数据
     * @return 相应数据的object
     */
    private static Object transferArguments(String type, String value) {
        type = type.toLowerCase();
        switch (type) {
            case "int":
                return Integer.valueOf(value);
            case "double":
                return Double.valueOf(value);
            case "float":
                return Float.valueOf(value);
            case "char":
                return (char)value.getBytes()[0];
            case "string":
                return value;
            default:
                System.out.println("undefined!");
                return null;
        }
    }
}
