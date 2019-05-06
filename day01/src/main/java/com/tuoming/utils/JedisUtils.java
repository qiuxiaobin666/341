package com.tuoming.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    static JedisPool pool;
    static {
        //ResourceBundle调用getBundle解析config文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        //读取数据
        String host = resourceBundle.getString("host");
        int port = Integer.parseInt(resourceBundle.getString("port"));
        int maxTotal = Integer.parseInt(resourceBundle.getString("maxTotal"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("maxIdle"));
        //获得连接池配置对象,并设置配置项
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(maxTotal);
        //设置最大空闲连接数
        config.setMaxIdle(maxIdle);
        //创建Jedis连接池
        pool = new JedisPool(config, host, port);
    }
    //创建静态方法,获得Jedis连接
    public static Jedis getJedis(){
        return pool.getResource();
    }
}
