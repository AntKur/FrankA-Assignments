<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Languages</title>
	</head>
	
	<body>
		<h1>Languages</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<td><a href="/languages/${language.id}">${language.name}</a></td>
					<td>${language.creator}</td>
					<td>${language.currentVersion}</td>
					<td>
						<a href="/languages/${language.id}/edit">Edit</a>
						<form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/languages/new">Add a language</a>
	</body>
</html>