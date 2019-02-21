package com.spring.jpa.springjpa.utilTools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 封装实体类数据工具类,
 * 获取实体属性名称和值.
 * @Auther: shalei
 * @Date: 2019/01/06 10:56
 * @Description:
 */
public class FieldMapUtil {

    /**
     * 获取实体字段数组
     * @param object
     * @return
     */
    public static Field[] getFields(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        return fields;
    }

    /**
     * 获取实体字段属性名称
     * @param field
     * @return
     */
    public static String getFieldName(Field field){
        String fieldName =  field.getName();
        String type = field.getType().toString();
        //System.out.println("属性名："+fieldName+"\t属性类型："+type);
        return fieldName;
    }

    /**
     * 获取实体字段属性名称值
     * @param fieldName
     * @param object
     * @return
     */
    public static String getFieldValue(String fieldName, Object object){
        String firstLetter=fieldName.substring(0,1).toUpperCase();
        String getter = "get"+firstLetter+fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(object, new Object[] {});
            return value.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
