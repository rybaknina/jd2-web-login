<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Test-system</title>
  </head>
  <body>

  <form action="controller" method="post">
    <input type="hidden" name="command" value="authorization" />
    Enter email:<br/>
    <input type="text" name="email" value="" /><br/>
    Enter password:<br/>
    <input type="password" name="password" value="" /><br/>
    <input type="submit" value="sign in" /><br/>

  </form>
  <h3>
    <%
      request.getAttribute("errMessage");
    %>
  </h3>
  </body>
</html>
