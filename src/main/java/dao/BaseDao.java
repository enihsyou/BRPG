package dao;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class BaseDao {
    //创建BasicDataSource类对象
    private static BasicDataSource datasource = new BasicDataSource();
   // static Connection conn=null;
    //静态代码块，对象BasicDataSource对象中的配置
    static{
        //数据库连接信息（必须）
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/geek_playstation");
        datasource.setUsername("root");
        datasource.setPassword("961021");
        //连接池中的连接数量配置（可选）
        datasource.setInitialSize(10);//初始化的连接数
        datasource.setMaxActive(8);//最大连接数
        datasource.setMaxIdle(5);//最大空闲连接
        datasource.setMinIdle(1);//最小空闲连接
    }
    //定义静态方法，返回BasicDataSource对象
    public static DataSource getDataSource(){
        return datasource;
    }


}
