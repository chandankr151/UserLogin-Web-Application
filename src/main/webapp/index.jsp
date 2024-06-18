<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="loginStyle.css">
</head>
<body>
<form action="loginServlet" method="post">
	<h1>Login</h1>
	<input type="text" id="usr" name="user" placeholder="Enter UserName" required> <br>
	<input type="password" id="pass" name="pass" placeholder="Enter Password" required><br>
	
	<button>Submit</button>

</form>
</body>
</html>