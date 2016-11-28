<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>


	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>


</head>


<body>
<h1>index.jsp</h1>
<h2>List of Books</h2>
	<table>
		<tr>
			<td>name</td> <td>book description</td> <td></td>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
			<td>${book.name}</td>
				<td>${book.description}</td>

			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newBook' />">Add New Book</a>

</body>
</html>