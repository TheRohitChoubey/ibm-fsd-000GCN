<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>




<body>
	<jsp:useBean id="e" class="jsp_demo_29th_08.Employee" scope="request">

		<form id="form-1" action="controller.do" method="post">
			<label for="input-1">Name</label> <input id="input-1" name="name"
				type="text" /> <br /> <label for="input-2">Address</label> <input
				id="input-2" name="address" type="text" /> <br /> <label
				for="input-3">Salary</label> <input id="input-3" name="salary"
				type="text" /> <input type="submit" value="Submit" id="button-1" />
		</form>
	</jsp:useBean>

	







</body>
</html>