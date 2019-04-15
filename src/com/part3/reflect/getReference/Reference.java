package com.part3.reflect.getReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Author: Sean
 * Date: Created In 17:39 2019/4/15
 * Title: 获取所有相关信息
 * Description: 输入一个类的名称，获取其类名、域、方法、修饰符以及构造函数
 * Version:
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Reference {
    public static void main(String[] args) {
        String className;
        // 从参数获取类名
        if (args.length > 0) {
            className = args[0];
        }
        // 从输入获取类名
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入类名: ");
            className = in.next();
        }

        try {
            // 根据类名称获得Class静态对象
            Class classForName = Class.forName(className);
            // 获取超类
            Class superClass = classForName.getSuperclass();
            // 获取类修饰符
            String modifier = Modifier.toString(classForName.getModifiers());

            // 输出类修饰符
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print("class " + className);
            // 输出超类名
            if (superClass != null && superClass != Object.class) {
                System.out.print("extends " + superClass.getName());
            }

            System.out.println(" {");
            printFields(classForName);
            System.out.println();
            printConstructors(classForName);
            System.out.println();
            printMethods(classForName);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            System.out.println("未找到该类！");
            e.printStackTrace();
        }
    }

    private static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for(Field field : fields){
            String modifier = Modifier.toString(field.getModifiers());
            Class type = field.getType();
            String name = field.getName();

            System.out.println("\t" + ((modifier.length() > 0)?(modifier + " "):"") + type.getName() + name+ ";");
        }
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for(Constructor constructor: constructors){
            String name = constructor.getName();
            String modifier = Modifier.toString(constructor.getModifiers());
            Class[] paramterTypes = constructor.getParameterTypes();

            System.out.print("\t");
            System.out.print((modifier.length()>0)?(modifier + " "):"");
            System.out.print(name);
            System.out.print("(");
            for(int i = 0; i < paramterTypes.length; i++){
                if(i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class cl){
        Method[] methods = cl.getMethods();
        for(Method method : methods){
            String modifier = Modifier.toString(method.getModifiers());
            String retType = method.getReturnType().getName();
            String name = method.getName();
            Class[] paramType = method.getParameterTypes();

            System.out.print("\t");
            System.out.print((modifier.length()>0)?(modifier + " "):"");
            System.out.print(retType + " " + name + "(");
            for(int i = 0; i < paramType.length; i++){
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(paramType[i].getName());
            }
            System.out.print(");\n");
        }
    }
}
