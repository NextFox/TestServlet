package main.java.com.nexta.controller;

import main.java.com.nexta.dao.WebsiteDao1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebSiteDeleteById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = new Integer(req.getParameter("id"));
        WebsiteDao1 websiteDao1 = new WebsiteDao1();
        websiteDao1.delteWebSiteById(id);


        req.getRequestDispatcher("/data").forward(req,resp);
       // resp.sendRedirect(req.getContextPath()+"/jsp/DetailWebSite.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
