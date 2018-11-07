package main.java.com.nexta.dao;

import main.java.com.nexta.model.WebSite;
import main.java.com.nexta.vo.WebSiteVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WebsiteDao1 {


    // JDBC 驱动名及数据库 URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = "root";
    public static final String PASS = "091933";

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    private ArrayList<WebSite> webSites = new ArrayList<>();


    public static Connection getConnection() {
        connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            //打开一个连接
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void updateWebSite(WebSite webSite) {
        try {
            connection = WebsiteDao1.getConnection();
            String sql = "update websites  set name = ?,url =?,country=? where id=?";

            int id = webSite.getId();
            String name = webSite.getName();
            String url = webSite.getUrl();
            int alexa = webSite.getAlex();
            String country = webSite.getCountry();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, url);
            preparedStatement.setString(3, country);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            WebsiteDao1.close(preparedStatement, connection, resultSet);
        }

    }

    public ArrayList<WebSite> findAll() throws SQLException {
        try {
            //建立连接
            connection = WebsiteDao1.getConnection();
            //执行sql查询
            statement = connection.createStatement();
            String sql = "select  * from websites";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                WebSite webSite = new WebSite();
                webSite.setId(resultSet.getInt("id"));
                webSite.setName(resultSet.getString("name"));
                webSite.setUrl(resultSet.getString("url"));
                webSite.setAlex(resultSet.getInt("alexa"));
                webSite.setCountry(resultSet.getString("country"));
                webSites.add(webSite);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            WebsiteDao1.close(statement, connection, resultSet);
        }
        return webSites;
    }

    public void insertWebsite(WebSite webSite) {
        try {
            connection = WebsiteDao1.getConnection();
            //statement= connection.createStatement();
            String sql = "insert into websites values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, webSite.getId());
            preparedStatement.setString(2, webSite.getName());
            preparedStatement.setString(3, webSite.getUrl());
            preparedStatement.setInt(4, webSite.getAlex());
            preparedStatement.setString(5, webSite.getCountry());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            WebsiteDao1.close(preparedStatement, connection, resultSet);
        }

    }

    //根据id查询
    public WebSite findWebsiteById(int id) {
        WebSite webSite = new WebSite();
        try {
            connection = WebsiteDao1.getConnection();
            String sql = "select * from websites where id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                webSite.setId(resultSet.getInt("id"));
                webSite.setName(resultSet.getString("name"));
                webSite.setUrl(resultSet.getString("url"));
                webSite.setAlex(resultSet.getInt("alexa"));
                webSite.setCountry(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            WebsiteDao1.close(preparedStatement, connection, resultSet);
        }

        return webSite;
    }

    //根据id删除网站数据

    public void delteWebSiteById(int id) {
        try {
            connection = WebsiteDao1.getConnection();
            String sql = "delete from websites where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        WebsiteDao1.close(preparedStatement, connection, resultSet);
    }


    //分页查询所有商品信息
    public List<WebSiteVo> findWebSiteByFenYe(int page) {
        List<WebSiteVo> webSiteVos = new ArrayList<>();
        connection = WebsiteDao1.getConnection();
        String sql = "select * from websites order by id asc limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page - 1) * WebSiteVo.PAGE_SIZE);
            preparedStatement.setInt(2, WebSiteVo.PAGE_SIZE);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WebSiteVo webSiteVo = new WebSiteVo();
                webSiteVo.setId(resultSet.getInt("id"));
                webSiteVo.setName(resultSet.getString("name"));
                webSiteVo.setUrl(resultSet.getString("url"));
                webSiteVo.setAlex(resultSet.getInt("alexa"));
                webSiteVo.setCountry(resultSet.getString("country"));
                webSiteVos.add(webSiteVo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return webSiteVos;
    }


    //查询总记录数
    public int findCount() {
        int count = 0;
        try {
            connection = WebsiteDao1.getConnection();
            String sql = "select count(*) from websites";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            WebsiteDao1.close(statement, connection, resultSet);
        }
        return count;
    }

    public static void close(Statement statement, Connection connection, ResultSet resultSet) {
        if (statement != null) {
            try {
                statement.close();
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

}
