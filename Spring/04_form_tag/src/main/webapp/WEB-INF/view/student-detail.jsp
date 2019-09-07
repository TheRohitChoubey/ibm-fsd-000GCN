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
	<h1>Data</h1>
	<br />
	<form:form action="processForm" modelAttribute="student">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${studentList}" var="map">
				<tr>
					<c:forEach items="${map}" var="entry">
						<td><c:out value="${entry.value}" /><br /></td>
					</c:forEach>
					<td><form:input path="firstName" item="${entry.value}"/></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>>

</body>
</html>