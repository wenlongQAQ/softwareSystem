<%--
  Created by IntelliJ IDEA.
  User: 所谓
  Date: 2022/11/7
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>cccc</title>
    </head>
    <body>
        <%
            out.write("您是第"+application.getAttribute("userNumber")+"访客");
        %>
        <a href="logout">退出</a>
    </body>
</html>

