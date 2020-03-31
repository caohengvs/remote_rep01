package com.caoheng.www;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DButils {
    private static DruidDataSource druidDataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DButils.class.getClassLoader().getResourceAsStream("database.properties"));
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDruidDataSource() {
        return druidDataSource;
    }
}
