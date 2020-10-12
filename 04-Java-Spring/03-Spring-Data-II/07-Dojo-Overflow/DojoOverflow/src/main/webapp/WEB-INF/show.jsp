<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Question Profile</title>
	</head>
	
	<body>
		<h1>${question.quest}</h1>
		<h3>Tags: ${question.getTagsAsString()} </h3>
		<table>
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${question.answers}" var="answer">
					<tr><td>${answer.answer}</td></tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>Add your answer:</h2>
		<form:form action="/questions/${question.id}/addanswer" method="POST" modelAttribute="answ">
			<p>
				<form:label path="answer">Answer</form:label>
				<form:errors path="answer"/>
				<form:textarea path="answer"/>
			</p>
			<form:hidden path="question" value="${question.id}"/>
			<input type="submit" value="Answer">
		</form:form>
	</body>
</html>