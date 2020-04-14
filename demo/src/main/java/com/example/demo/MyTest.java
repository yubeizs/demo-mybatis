package com.example.demo;

import com.example.annotion.Color;
import com.example.vo.Apple;

import java.lang.reflect.Field;

public class MyTest {
    public static void main(String[] args) throws Exception{

        // 加载类
        Class<?> appleClass = Class.forName("com.example.vo.Apple");
       //这样也可以  Class<? extends Apple> appleClass = new Apple().getClass();
        Field[] fields = appleClass.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            Color color = field.getAnnotation(Color.class);
            if (color != null){  // 说明有Color 的注解
                System.out.println("apple 的颜色是：" + color.value());
                System.out.println(" 属性的名称是： " + field.getName());
            }
            break;
        }
        System.out.println("this is end.....");
    }
}
