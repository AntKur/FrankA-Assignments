<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Top Songs</title>
	</head>
	
	<body>
		<p>Top Ten Songs:</p>
		<a href="/dashboard">Dashboard</a>
		<c:forEach items="${songs}" var="song">
			<p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
		</c:forEach>
	</body>
</html>