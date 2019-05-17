<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<form action="login" method="post">
<tr><th>Username:</th><th><input type="text" name="username" required></th></tr>
<tr><th>Password:</th><th><input type="password" name="password" required></th></tr>
<tr><th><input type="submit" value="login"></th></tr>
<tr><th><a href="Registration.jsp">Registration</a></th>
<th><a href="forget.jsp">forget password</a></th></tr>
</form>
</table>
</center>
</body>
</html>