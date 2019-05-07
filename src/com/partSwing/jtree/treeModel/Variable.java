package com.partSwing.jtree.treeModel;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 10:59 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Variable {
    private Class<?> type;
    private Object value;
    private String name;
    private List<Field> fields;

    /**
     * construtor
     *
     * @param type  Class<?>
     * @param name  VariableName
     * @param value VariableObject
     */
    public Variable(Class<?> type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
        fields = new ArrayList<>();

        if (!type.isPrimitive() && !type.isArray() && !type.equals(String.class) && value != null) {
            for (Class<?> c = value.getClass(); c != null; c = c.getSuperclass()) {
                Field[] classFields = c.getDeclaredFields();
                AccessibleObject.setAccessible(classFields, true);
                // 添加所有非静态域
                for (Field field : classFields) {
                    if ((field.getModifiers() & Modifier.STATIC) == 0) {
                        fields.add(field);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String ret = type + " " + name;
        if (type.isPrimitive()) ret += "=" + value;
        else if (type.equals(String.class)) ret += "=" + value;
        else if (value == null) ret += "null";
        return ret;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
