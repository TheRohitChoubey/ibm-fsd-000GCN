<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	Student FirstName:${tempStudent.firstName}
	<br /> Student LastName:${tempStudent.lastName}

	<br /> Student Language:${tempStudent.language}

	<br /> Student Country:${tempStudent.country}
	
	<br/>Operating System : <c:forEach var="osList" items="${tempStudent.os}">
		<c:out value="${osList}" />
	</c:forEach>
</body>
</html>