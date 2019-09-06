<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Process</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name : <form:input path="firstName" />
		<br />
	Last Name : <form:input path="lastName" />
		<br />
	Country : <form:select path="country">
			<form:options items="${student.countryOptions}"></form:options>
		</form:select>
		<br />
		
		<form:radiobuttons path="language" items="${student.languageOptions}" />
		<br/>
		<form:checkboxes path="os" items="${student.osList}" />
		<br/>
		
		<input type="submit" />
		<br />
	</form:form>
	
	<a href = "/student/getData">
</body>
</html>