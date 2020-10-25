<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Events</title>
	</head>
	
	<body>
		<h1>Welcome, ${user.firstName}</h1>
		<a href="/logout">Logout</a>
		<p>Here are some of the events in your state.</p>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${eventsInState}" var="event">
					<tr>
						<td><a href="/events/${event.id}">${event.name}</a></td>
						<td>${event.eventDateFormatted()}</td>
						<td>${event.city}</td>
						<td>${event.creator.firstName}</td>
						<c:choose>
						<c:when test="${event.creator.id == user.id }"><a href="/events/edit">Edit</a> <a href="/events/delete">Delete</a></c:when>
						<c:when test="${user.eventsGoingTo.contains(event)}">Joining <a href="#">Cancel</a></c:when>
						<c:otherwise><a>Join</a></c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>Here are some events in other states/</p>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${eventsOutState}" var="event">
					<tr>
						<td><a href="/events/${event.id}">${event.name}</a></td>
						<td>${event.eventDateFormatted()}</td>
						<td>${event.city}</td>
						<td>${event.state}</td>
						<td>${event.creator.firstName}</td>
						<c:choose>
						<c:when test="${event.creator.id == user.id }"><a href="/events/edit">Edit</a> <a href="/events/delete">Delete</a></c:when>
						<c:when test="${user.eventsGoingTo.contains(event)}">Joining <a href="#">Cancel</a></c:when>
						<c:otherwise><a>Join</a></c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>Create an Event</h2>
		<form:form action="/events/new" method="POST" modelAttribute="event">
			<form:hidden path="creator" value="${user.id}"></form:hidden>
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="eventDate">Date</form:label>
				<form:errors path="eventDate"/>
				<form:input type="date" path="eventDate"/>
			</p>
			<p>
				<form:label path="city">Location</form:label>
				<form:errors path="city"/>
				<form:input path="city"/>
							
				<form:errors path="state"/>
				<form:select path="state" items="${user.getStates()}"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
	</body>
</html>