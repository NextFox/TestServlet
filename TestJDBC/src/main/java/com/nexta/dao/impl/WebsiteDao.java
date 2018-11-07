package main.java.com.nexta.dao.impl;

import main.java.com.nexta.model.WebSite;
import main.java.com.nexta.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;

public class WebsiteDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private ArrayList<WebSite> webSites = new ArrayList<>();

    public ArrayList<WebSite> findAllWebSites() {

        try {
            connection = DbUtil.getCon();
            String sql = "select * from websites";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);


            while (resultSet.next()) {
                WebSite website = new WebSite();
                website.setId(resultSet.getInt("id"));
                website.setName(resultSet.getString("name"));
                website.setUrl(resultSet.getString("url"));
                website.setAlex(resultSet.getInt("alexa"));
                website.setCountry(resultSet.getString("country"));
                webSites.add(website);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(preparedStatement, connection, resultSet);
        }


        return webSites;
    }
}
