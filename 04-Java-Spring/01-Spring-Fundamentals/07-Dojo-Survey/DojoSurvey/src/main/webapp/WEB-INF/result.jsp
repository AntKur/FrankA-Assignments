<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
	<title>Your Dojo Durvey</title>
	</head>
	
	<body>
		<div class="wrapper">
			<h1 class="result-header">Submitted Info</h1>
			<div class="info">
			<p>Name:</p>
			<p>${name}</p>
			<p>Dojo Location:</p>
			<p>${location}</p>
			<p>Favorite Language:</p>
			<p>${language}</p>
			<p>Comment:</p>
			<p>${comment}</p>
			<button id="back" onclick="location.href = '/' ">Go Back</button>
			</div>
		</div>
	</body>
</html>