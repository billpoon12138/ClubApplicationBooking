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

<h1>New Booking page</h1>
<form:form method="POST" commandName="booking"
	action="${pageContext.request.contextPath}/booking/create.html">
	<table class="table">
		<tbody>
			<tr>
				<td>UserID:</td>
				<td><form:input path="userID" /></td>
				<!-- <td><form:errors path="userID" cssStyle="color: red;"/></td> -->
			</tr>
			<tr>
				<td>FacilityID:</td>
				<td><form:input path="facilityID" /></td>
				<!-- <td><form:errors path="facilityID" cssStyle="color: red;"/></td> -->
			</tr>
			<tr>
				<td>Check-in :</td>
				<td><form:input path="bookingDate" type="text" id="datepicker1" /></td>
				<!-- <td><form:input path="bookingDate" /></td> -->
				<!--  <td><p><input type="text" id="datepicker"></p></td> -->
				<!-- <td><form:errors path="bookingDate" cssStyle="color: red;"/></td> -->
			</tr>
			<tr>
				<td>Check-out :</td>
				<td><form:input path="checkoutDate" type="text"
						id="datepicker2" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" class="btn"/></td>
				<td><input type="reset" value="Reset" class="btn"/></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
