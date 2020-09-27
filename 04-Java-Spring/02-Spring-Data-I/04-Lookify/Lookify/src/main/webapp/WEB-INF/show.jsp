<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Details</title>
	</head>
	
	<body>
		<a href="/dashboard">Dashboard</a>
		<p>Title:</p>
		<p>${song.title}</p>
		<p>Artist</p>
		<p>${song.artist}</p>
		<p>Rating(1-10)</p>
		<p>${song.rating}</p>
		<form action="/songs/${song.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</body>
</html>