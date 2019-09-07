<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Data</title>
</head>
<body>
	<table>
		<tr>
			<th>Title</th>
			<th>Name</th>
			<th>Cd_type</th>
		</tr>
		<tbody>
			<%
				List list = (List)request.getAttribute("tabledata");
				int i=0;
				while(i<list.size()){
			%>
			<tr>
				<td>list.get(i).firstname</td>
				<td>list.get(i).lastname</td>
				<td>list.get(i).cd_type</td>
			</tr>
			<%
					i++;
				}
			%>
		</tbody>
	</table>
</body>
</html>