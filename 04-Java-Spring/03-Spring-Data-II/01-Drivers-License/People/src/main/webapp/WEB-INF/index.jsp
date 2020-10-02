<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People</title>
</head>
<body>
	<c:forEach items="${people}" var="person">
		<p><a href="/persons/${person.id}">${person.firstName} ${person.lastName}</a></p>
	</c:forEach>
	<a href="/persons/new">Add Person</a>
	<a href="/licenses/new">Add License</a>
</body>
</html>