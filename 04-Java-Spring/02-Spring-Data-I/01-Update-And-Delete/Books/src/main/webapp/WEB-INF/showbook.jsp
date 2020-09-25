<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>${book.title}</title>
	</head>
	
	<body>
		<h1>${book.title}</h1>
		<p>Description: ${book.description}</p>
		<p>Language: ${book.language}</p>
		<p>Number of Pages: ${book.numOfPages}</p>
		<a href="/books/${book.id}/edit">Edit Book</a>
		<form action="/books/${book.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</body>
</html>