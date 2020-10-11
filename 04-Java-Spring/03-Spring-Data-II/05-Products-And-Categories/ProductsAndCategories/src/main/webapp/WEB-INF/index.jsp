<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Products And Categories</title>
	</head>
	
	<body>
		<h1>Products and Categories</h1>
		<a href="/categories/new">Add Category</a>
		<a href="/products/new">Add Product</a>
		<table>
			<thead>
				<tr>
					<th>Categories</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td><a href="/categories/${category.id}">${category.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table>
			<thead>
				<tr>
					<th>Products</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href="/products/${product.id}">${product.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>