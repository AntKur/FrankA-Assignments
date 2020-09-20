<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
	<title>Dojo Survey</title>
	</head>
	
	<body>
		<div class="wrapper">
			<h3 class="red">${errors}</h3>
			<form method="POST" action="/result">
				<label for="male">Your Name:</label>
				<input type="text" name="name">
				<label for="location">Dojo Location:</label>
				<select name="location">
					<option value="">Select Location...</option>
					<option value="Arlington">Arlington</option>
					<option value="Bellevue">Bellevue</option>
					<option value="Boise">Boise</option>
					<option value="Chicago">Chicago</option>
					<option value="Dallas">Dallas</option>
					<option value="LA">LA</option>
					<option value="Oakland">Oakland</option>
					<option value="OC">OC</option>
					<option value="San Jose">San Jose</option>
					<option value="Seattle">Seattle</option>
					<option value="Tulsa">Tulsa</option>
					<option value="Online">Online</option>
				</select>
				<label for="language">Favorite Language:</label>
				<select name="language">
						<option value="">Select Language...</option>
						<option value="C">C</option>
						<option value="C#">C#</option>
						<option value="C++">C++</option>
						<option value="Haskell">Haskell</option>
						<option value="Java">Java</option>
						<option value="JavaScript">JavaScript</option>
						<option value="Python">Python</option>
						<option value="Ruby">Ruby</option>
					</select>
				<label for="comment">Comment (optional):</label>
				<textarea type="text" name="comment"></textarea>
				<button id="submit">Submit</button>
			</form>
		</div>
	</body>
</html>