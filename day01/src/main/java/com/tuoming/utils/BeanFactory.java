package com.tuoming.utils;



import java.util.ResourceBundle;

public class BeanFactory {

    public static <T> T getInstanse(Class<T> clazz){
        //读取配置文件,找出接口和实现类的对应键值对
        //clazz对象方法,调用getSimpleName()方法,获得相应的类名或者接口名
        String simpleName = clazz.getSimpleName();
        //调用静态方法读取配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bean");
        //获取全类名
        String className = resourceBundle.getString(simpleName);
        //定义对象
        T t = null;
        try {
            Class clz = Class.forName(className);
            t = (T)clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
