<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Save</title>
</head>
<body>
	<button value="Back"
		onclick="window.location.href='http://localhost:8080/'">Back</button>
	<form:form action="editSaveDetails" modelAttribute="customer">
first name<form:input path="firstName" />
		<br />
last name<form:input path="lastName" />
		<br />
email<form:input path="email" />
		<br />
		<form:hidden path="id" />
		<br />
		<input type="submit">
	</form:form>
</body>
</html>