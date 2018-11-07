package main.java.com.nexta.controller;

import main.java.com.nexta.dao.WebsiteDao1;
import main.java.com.nexta.model.WebSite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebSiteSearchById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebsiteDao1 websiteDao1 = new WebsiteDao1();
        int id = new Integer(req.getParameter("id"));
        WebSite webSite = websiteDao1.findWebsiteById(id);

        //1：将字符串保存到session中
        req.getSession().setAttribute("website", webSite);
        //req.getRequestDispatcher("index.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/jsp/DetailWebSite.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
