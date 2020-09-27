<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Lookify!</title>
	</head>
	
	<body>
		<a href="/songs/new">Add New</a>
		<a href="search/topTen">Top Songs</a>
		<form action="/search" method="get">
			<input type="text" name="search">
			<input type="submit" value="Searh Artists">
		</form>
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}">${song.title}</a></td>
						<td>${song.rating}</td>
						<td>
							<form action="/songs/${song.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>