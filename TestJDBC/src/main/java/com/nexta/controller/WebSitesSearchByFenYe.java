package main.java.com.nexta.controller;

import main.java.com.nexta.dao.WebsiteDao1;
import main.java.com.nexta.vo.WebSiteVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class WebSitesSearchByFenYe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当前页
        int currPage = 1;
        if (req.getParameter("page") != null) {
            currPage = Integer.parseInt(req.getParameter("page"));
        }
        WebsiteDao1 websiteDao1 = new WebsiteDao1();
        List<WebSiteVo> webSiteVoList = websiteDao1.findWebSiteByFenYe(currPage);
        req.setAttribute("webSites", webSiteVoList);
        //总页数
        int pages;
        //查询总记录数
        int count = websiteDao1.findCount();
        //计算总页数
        if (count % WebSiteVo.PAGE_SIZE == 0) {
            pages = count / WebSiteVo.PAGE_SIZE;
        } else {
            pages = count / WebSiteVo.PAGE_SIZE + 1;
        }

        StringBuffer stringBuffer = new StringBuffer();
        //循环构建分页导航条
        for (int i = 1; i <= pages; i++) {
            //判断是否为当前页
            if (i == currPage) {
                //构建分页导航条
                stringBuffer.append("^" + i + "^");
            } else {
                stringBuffer.append("<a href='/WebSitesSearchByFenYe?page=" + i + "'>" + i + "</a>");
            }
            stringBuffer.append(" ");
        }
        req.setAttribute("bar", stringBuffer.toString());
        req.getRequestDispatcher("jsp/WebSiteSearchByFenYe.jsp").forward(req,resp);
        //resp.sendRedirect(req.getContextPath() + "/jsp/WebSiteSearchByFenYe.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}