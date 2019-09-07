<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Main</title>
</head>
<body>
	<form action="main_serve" method="post">
		first name<input type="text" name="fname"><br /> 
		last name<input type="text" name="lname"><br />
		Cd_type<select name = "cd_type">
			<option>local</option>
			<option>special</option>
			<option>international</option>
		</select><br/>
		<input type="submit">
	</form>
	
	<a href = "display.view">Click here </a>
</body>
</html>
