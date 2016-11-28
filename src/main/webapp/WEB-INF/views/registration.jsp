<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>
	<h1>registration.jsp</h1>
	<h2>Add New Book</h2>
 
	<form:form method="POST" action="/newBook" modelAttribute="book">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>

		    </tr>
	    
			<tr>
				<td><label for="description">Description : </label> </td>
				<td><form:input path="description" id="description"/></td>

		    </tr>
	
			<tr>
				<td> <input type="submit" value="Save"/></td>
			</tr>

		</table>
	</form:form>

	<br/>
	<br/>
	Go back to <a href="<c:url value='/' />">List of All Employees</a>
</body>
</html>