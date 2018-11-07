<%--
  Created by IntelliJ IDEA.
  User: nexta
  Date: 2018/11/6
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/website/update" method="post" name="insertWebsite">
    id:      <input type="text" name="id"><br>
    网站名称: <input type="text" name="name"></br>
    url:     <input type="text" name="url"></br>
    国家:      <input type="text" name="country">
    <input type="submit" value="提交">
</form>

</body>
</html>
