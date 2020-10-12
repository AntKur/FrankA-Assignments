<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Questions Dashboard</title>
	</head>
	
	<body>
		<h1>Questions Dashboard</h1>
		<table>
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${questions}" var="q">
					<tr>
						<td><a href="/questions/${q.id}">${q.quest}</a></td>
						<td>${q.getTagsAsString()}</td>
					</tr>
				</c:forEach>
			</tbody>
			<a href="/questions/new">New Question</a>
		</table>
	</body>
</html>