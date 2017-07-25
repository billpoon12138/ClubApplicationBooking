<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker1").datepicker();
	});
	$(function() {
		$("#datepicker2").datepicker();
	});
</script>
<html>
<h1>My Booking</h1>
<form:form method="POST" modelAttribute="booking"
	action="${pageContext.request.contextPath}/booking/searchm">
	<table style="text-align: center;">
		<tr>
			<td><h5>Member Name:</h5></td>
			<td><form:input path="userID" readonly="true" name="userID"/></td>
			<td><h5>Start Date:</h5></td>
			<td><input name="startDate" type="text" id="datepicker1" /></td>
			<td><h5>End Date:</h5></td>
			<td><input name="endDate" type="text" id="datepicker2" /></td>
			<td><h5>Booking Status:</h5></td>
			<td><form:select path="bookingStatus" name="bookingStatus">
					<form:options items="${statusList}" />
				</form:select></td>
			<td><input type="submit" name="submit" value="Search" /></td>
		</tr>
	</table>
</form:form>
<table style="text-align: center;" border="1px" cellpadding="0"
	cellspacing="0" class="table table-hover">
	<thead>
		<tr>
			<td>Booking ID</td>
			<td>Member Name</td>
			<td>Facility Name</td>
			<td>Check-in Date</td>
			<td>Status</td>
			<td>Edit/Cancel</td>
	</thead>
	<tbody>
		<c:forEach var="booking" items="${bookingList}">
			<tr>
				<td>${booking.bookingID}</td>
				<td>${booking.memberName}</td>
				<td>${booking.facilityName}</td>
				<td>${booking.bookingDate}</td>
				<td>${booking.bookingStatus}</td>
				<td><a
					href="${pageContext.request.contextPath}/booking/edit/${booking.bookingID}.html">Edit</a><br />
					<a
					href="${pageContext.request.contextPath}/booking/cancel/${booking.bookingID}.html">Cancel</a><br />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</html>