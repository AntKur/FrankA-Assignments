<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
	<title>Secret Code</title>
	</head>
	
	<body>
		<p class="red">${errors}</p>
		<form method="POST" action="/code">
		<label>What is the code?</label>
		<input type="password" name="code">
		<button>Try Code</button>
		</form>
	</body>
	
</html>