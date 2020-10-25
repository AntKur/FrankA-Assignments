<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="container">
			<h1>Welcome</h1>
			<div class="row">
				<div class="col">
					<h3>Register</h3>
					<form:form action="/register" method="POST" modelAttribute="user">
						<p>
							<form:label path="firstName">First Name</form:label>
							<form:errors path="firstName"/>
							<form:input path="firstName"/>
						</p>
						<p>
							<form:label path="lastName">Last Name</form:label>
							<form:errors path="lastName"/>
							<form:input path="lastName"/>
						</p>
						<p>
							<form:label path="email">Email</form:label>
							<form:errors path="email"/>
							<form:input type="email" path="email"/>
						</p>
						<p>
							<form:label path="city">Location</form:label>
							<form:errors path="city"/>
							<form:input path="city"/>
							
							<form:errors path="state"/>
							<form:select path="state" items="${user.getStates()}"/>
						</p>
						<p>
							<form:label path="password">Password</form:label>
							<form:errors path="password"/>
							<form:input path="password"/>
						</p>
						<p>
							<form:label path="confirmPassword">Confirm Password</form:label>
							<form:errors path="confirmPassword"/>
							<form:input path="confirmPassword"/>
						</p>
						<input type="submit" value="Register"/>
					</form:form>
				</div>
				
				<div class="col">
				<h3>Login</h3>
					<form action="/login" method="POST">
						<div class="form-group">
							<label for="email">Email</label>
							<input type="email" name="email"/>
						</div>	
						<div class="form-group">
							<label for="password">Password</label>
							<input type="password" name="password"/>
						</div>	
						<input type="submit" value="Login"/>
					</form>		
				</div>
			</div>	
		</div>	
	</body>
</html>