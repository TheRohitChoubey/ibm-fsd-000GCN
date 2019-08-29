
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<h1>Add Employee</h1>
	 <jsp:useBean id="u" class="comm.example.model.Employee" scope="request">
	<jsp:setProperty name="u" property="password" param="pass" />
	<jsp:setProperty name="u" property="email" param="email" />
	</jsp:useBean>
	You entered user email as
	<jsp:getProperty name="u" property="email" />
	<br> You entered user password as
	<jsp:getProperty name="u" property="password"/>
	<br>

	<br>

	<b>Thank You</b>

	<form action=add_employee.dao method=post>
		Name:<input type=text name=uName /><br /> <br /> Password:<input
			type=password name=uPass /><br /> <br /> Email Id:<input type=text
			name=uEmail /><br /> <br /> Country: <select name=uCountry>
			<option>India</option>
			<option>Pakistan</option>
			<option>other</option>
		</select> <br /> <br /> <input type=submit value=register />

	</form>
	<br>
	<a href=employee_list.view>View Employee List</a>
</body>
</html>