<%--
  Created by IntelliJ IDEA.
  User: nexta
  Date: 2018/11/6
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="main.java.com.nexta.model.WebSite"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${website}" var="li">
    <c:out value="id : ${li.id}"></c:out>
    <c:out value="name: ${li.name}"></c:out>
    <c:out value="url: ${li.url}"></c:out>
    <c:out value="alexa: ${li.alex}"></c:out>
    <c:out value="country${li.country}"></c:out>
    <button type="button" value="查询"><a href="/website/search?id=${li.id}">详情</a></button>
    <button type="button" value=""><a href="/website/delete?id=${li.id}">删除</a></button>
    <button type="button" value="插入"><a href="/jsp/InsertWebsite.jsp">插入</a></button>
    <button type="button" value="更新"><a href="/jsp/UpdateWeSite.jsp">更新</a></button>

    </br>
</c:forEach>


</body>
</html>
