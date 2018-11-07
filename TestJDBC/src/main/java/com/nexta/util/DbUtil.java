package main.java.com.nexta.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {

    // JDBC 驱动名及数据库 URL
    /*public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = "root";
    public static final String PASS = "091933";*/

    private static String JDBC_DRIVER = null;
    private static String DB_URL = null;
    private static String USER = null;
    private static String PASS = null;

    Connection conn = null;
    Statement stmt = null;
    // 设置响应内容类型

    static {
        Properties prop = new Properties();


        //将数据mysql基础数据进行解耦
        InputStream inputStream = DbUtil.class.getResourceAsStream("/main/resources/db.properties");

        try {
            prop.load(inputStream);
            JDBC_DRIVER = prop.getProperty("jdbc_driver");
            DB_URL = prop.getProperty("jdbc_url");
            USER = prop.getProperty("jdbc_user");
            PASS = prop.getProperty("jdbc_password");

            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取连接对象

    public static Connection getCon() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    //关闭方法
    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int add1(int a,int b){
        return a+b;
    }

    public int add2(int a,int b){
        return a+b;
    }


    @Test
    public void testStatic(){
        System.out.println(DbUtil.add1(34,78));

        DbUtil dbUtil =new DbUtil();
        System.out.println(dbUtil.add2(23,45));
    }

}
