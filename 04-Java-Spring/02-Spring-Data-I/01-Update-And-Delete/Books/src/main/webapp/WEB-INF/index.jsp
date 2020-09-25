<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Books</title>
	</head>
	
	<body>
		<h1>All Books</h1>
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th>Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.description}</td>
					<td>${book.language}</td>
					<td>${book.numOfPages}</td>
					<td><a href="/books/${book.id}/delete">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/books/new">Add New Book</a>
	</body>
</html>