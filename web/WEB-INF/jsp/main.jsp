<%@ page import="by.htp.ts.bean.User" %>
<%@ page import="com.mysql.jdbc.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 12.11.2019
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<a href="index.jsp">go home</a><br/>
<%

    User user = (User)request.getAttribute("user");

    String message = (String) request.getAttribute("errMessage");
    if (message != null)
    {
        out.println(request.getAttribute("errMessage"));
        return;
    }
    else {
        out.println("Hello, you are winner!");
        out.println(user.getEmail());
    }
%>
</body>
</html>
