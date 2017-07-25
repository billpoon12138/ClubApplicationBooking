
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<h1>Search Facility</h1>
<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/facility/searchm">
	<table style="text-align: center;">
		<tr>
			<td><h5>Category:</h5></td>
			<td><form:select path="categoryID" name="categoryID">
					<form:options items="${cateName}" />
				</form:select></td>
			<td><h5>Facility Name:</h5></td>
			<td><input name="facName" type="text" size="15" /></td>
			<td><input type="submit" name="submit" value="submit" /></td>
	</table>
	<table style="text-align: center;" border="1 px">
		<thead>
			<tr>
				<td>Facility ID</td>
				<td>Facility Name</td>
				<td>Category Name</td>
				<td>Status</td>
				<td>Remarks</td>
				<td>Book</td>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilityList}">
				<tr>
					<td>${facility.facilityID}</td>
					<td>${facility.facilityName}</td>
					<td>${facility.categoryID}</td>
					<td>${facility.status}</td>
					<td>${facility.remarks}</td>
					<td><a
						href="${pageContext.request.contextPath}/booking/create/${facility.facilityID}.html">Book</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form:form>
</html>