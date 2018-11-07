package main.java.com.nexta.controller;

import main.java.com.nexta.dao.WebsiteDao1;
import main.java.com.nexta.model.WebSite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebSiteUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       super.doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = new Integer(req.getParameter("id"));
        String name = new String(req.getParameter("name"));
        String url = new String(req.getParameter("url"));
        String country = new String(req.getParameter("country"));

        WebSite webSite = new WebSite();
        webSite.setId(id);
        webSite.setName(name);
        webSite.setUrl(url);
        webSite.setCountry(country);
        WebsiteDao1 websiteDao1 =new WebsiteDao1();
        websiteDao1.updateWebSite(webSite);
        req.getRequestDispatcher("/data").forward(req,resp);
    }
}
