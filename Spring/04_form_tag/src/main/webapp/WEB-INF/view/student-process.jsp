<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<br />
		<form:checkboxes path="os" items="${student.osList}" />
		<br />

		<input type="submit" />
		<br />
	</form:form>

	<a href="/student/getData">Click here</a>

	<form:form action="searchByName" modelAttribute="student">
		First Name : <form:input path="firstName" />
		<input type="submit" />
		<br />
	</form:form>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${foundStudent}" var="map" varStatus="status">
			<tr>
				<c:forEach items="${map}" var="entry">
					<td><c:out value="${entry.value}" /><br /></td>
				</c:forEach>
				<td><a
					href="${contextPath}/student/getName?order=${foundStudent[status.index].id} ">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>