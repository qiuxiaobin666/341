package com.tuoming.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Utils {
    // 1. 创建连接池
   private static ComboPooledDataSource pool = new ComboPooledDataSource();

   // 加入 ThreadLocal 对象 ,用来绑定连接 .
    private  static ThreadLocal<Connection>  tl= new ThreadLocal<>();


    // 2. 提供静态方法获取连接
    public static Connection getConnection(){
        try {

            // 获取的连接, 应该是与当前线程绑定的连接对象
            Connection connection = tl.get();

            // 首次拿 , 获取null, 此时绑定 一条 连接对象
            if (connection == null) {
                // 从连接池获取一条连接
                connection = pool.getConnection();
                // 与当前线程绑定.
                tl.set(connection);
            }


            return connection;
        }catch (Exception e) {
            System.out.println(e.toString());
        }


        return  null;
    }

    // 3. 提供 获取连接池的方法
    public static DataSource  getDS(){
        return  pool;
    }
 }
