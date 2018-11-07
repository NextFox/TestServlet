package main.java.com.nexta.controller;

import main.java.com.nexta.dao.WebsiteDao1;
import main.java.com.nexta.model.WebSite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WebSiteFindAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebsiteDao1 websiteDao = new WebsiteDao1();
        ArrayList<WebSite> arrayList = null;
        try {
            arrayList = websiteDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //1：将字符串保存到session中
        req.getSession().setAttribute("website", arrayList);
        //req.getRequestDispatcher("jsp/SearchAllWebsite.jsp").forward(req, resp);

        resp.sendRedirect(req.getContextPath() + "/jsp/SearchAllWebsite.jsp");

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
