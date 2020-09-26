<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
		
		<p>Name: ${language.name}</p>
		<p>Creator: ${language.creator}</p>
		<p>Current Version: ${language.currentVersion}</p>
		<a href="/languages/${language.id}/edit">Edit Language</a>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
</body>
</html>