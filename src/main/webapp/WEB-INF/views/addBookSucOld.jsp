<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h1>addBookSuc.jsp</h1>
	<h2>This Book</h2>
	<table>
		<tr>
			<td>name</td> <td>book description</td> <td></td>
		</tr>

			<tr>
			<td>${book.name}</td>
				<td>${book.description}</td>
			</tr>

	</table>

	<br/>

	<a href="<c:url value='/index' />">Save and Add Author</a>

	<td><a href="<c:url value='/newAuthor-${book}' />">Add Author</a></td>

</body>
</html>