<%@ page import="by.htp.ts.bean.User" %>
<%@ page import="com.mysql.jdbc.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 12.11.2019
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
