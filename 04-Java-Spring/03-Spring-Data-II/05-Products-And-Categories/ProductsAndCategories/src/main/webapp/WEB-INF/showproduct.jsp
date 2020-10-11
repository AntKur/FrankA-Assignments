<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Product Page</title>
	</head>
	
	<body>
		<h1>${product.name}</h1>
		<div>
			<h3>Categories:</h3>
			<c:forEach items="${product.categories}" var="category">
				<p>- ${category.name}</p>
			</c:forEach>
		</div>
		
		<div>
			<form action="/products/${product.id}/add" method="POST">
				<label for="categoryId">Add Category: </label>
				<select name="categoryId">
					<c:forEach items="${categories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add"/>
			</form>
		</div>
	</body>
</html>