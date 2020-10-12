<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>New Question</title>
	</head>
	
	<body>
		<h1>What is your question?</h1>
		<form:form action="/questions" method="POST" modelAttribute="question">
			<p>
				<form:label path="quest">Question</form:label>
				<form:errors path="quest"/>
				<form:textarea path="quest"/>
			</p>
			<p>
				<form:label path="tagString">Tags</form:label>
				<form:errors path="tagString"/>
				<form:input path="tagString"/>
			</p>
			<input type="submit" value="Submit">
		</form:form>
	</body>
</html>