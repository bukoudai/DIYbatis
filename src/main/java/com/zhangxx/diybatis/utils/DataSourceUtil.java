package com.zhangxx.diybatis.utils;

import com.zhangxx.diybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg) throws Exception {
        //加载数据库驱动
        Class.forName(cfg.getDriver());

        //通过驱动管理类获取数据库链接
        return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
    }
}
