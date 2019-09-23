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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1>Data</h1>
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${studentList}" var="map" varStatus="status">
			<tr>
				<c:forEach items="${map}" var="entry">
					<td><c:out value="${entry.value}" /><br /></td>
				</c:forEach>
				<td><a
					href="${contextPath}/student/getName?order=${studentList[status.index].id} ">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>