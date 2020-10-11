<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Category Page</title>
	</head>
	
	<body>
		<h1>${category.name}</h1>
		<div>
			<h3>Products:</h3>
			<c:forEach items="${category.products}" var="product">
				<p>- ${product.name}</p>
			</c:forEach>
		</div>
		
		<div>
			<form action="/categories/${category.id}/add" method="POST">
				<label for="productId">Add Product: </label>
				<select name="productId">
					<c:forEach items="${products}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add"/>
			</form>
		</div>
	</body>
</html>