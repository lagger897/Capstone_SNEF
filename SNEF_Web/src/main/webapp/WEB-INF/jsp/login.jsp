<%--
  Created by IntelliJ IDEA.
  User: NhanN
  Date: 7/15/2019
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h3>Welcome Login Page</h3>
    <form action="/api/login" method="POST">
        <label>Username</label>
        <input type="text" value="" name="name" />
        <br/>
        <label>Password</label>
        <input type="password" name="password" value=""/>
        <br/>

        <input type="submit" name="Login" />
        <input type="reset" name="Reset" />
    </form>
</body>
</html>
