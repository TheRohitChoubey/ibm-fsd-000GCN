<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<h1>Login</h1>
	<form action="verify_employee.dao" method="post">
		Email Id:<input type="text" name="email" /><br /><br />
		Password :<input type="text" name="pass" /><br /><br />
		<br /> <input type="submit" value="Enter" />
	</form>
	<br>
</body>
</html>