<%@ page import="main.java.com.nexta.vo.WebSiteVo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: nexta
  Date: 2018/11/6
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示网站列表</title>
    <style type="text/css">
        td, th {
            padding: 5px;
            background-color: #FFFFFF;
        }

        .div1 {
            width: 98%;
            text-align: center;
        }

        .div2 {
            width: 98%;
            text-align: center;
            padding: 10px 0 0 0;
        }

        table {
            width: 98%;
            border: 0;
            text-align: center;
            background-color: #666666;
        }
    </style>
</head>
<body>
<div class="div1">
    <h2>分页显示网站列表</h2>
    <table cellpadding="0" cellspacing="1">
        <tr>
            <th>ID</th>
            <th>网站名称</th>
            <th>URL地址</th>
            <th>alexa排名</th>
            <th>所属国家</th>
        </tr>

        <%
            //获取网站信息集合
            List<WebSiteVo> webSiteVos = (List<WebSiteVo>) request.getAttribute("webSites");
            if (webSiteVos == null || webSiteVos.size() < 1) {
                //PrintWriter out = null;
                System.out.print("<tr><td colspan='5'>没有任何图书信息！</td></tr>");
                return;
            } else {
                for (WebSiteVo webSiteVo : webSiteVos) {
        %>
        <tr>
            <td><%=webSiteVo.getId()%>
            </td>
            <td><%=webSiteVo.getName()%>
            </td>
            <td><%=webSiteVo.getUrl()%>
            </td>
            <td><%=webSiteVo.getAlex()%>
            </td>
            <td><%=webSiteVo.getCountry()%>
            </td>


        </tr>
        <%
                }
            }

        %>

    </table>
    <div class="div2">
        <%=request.getAttribute("bar")%>
    </div>
</div>


</body>
</html>
