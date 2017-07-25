
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<h1>Search Facility</h1>
<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/facility/searcha">
	<table style="text-align: center;">
		<tr>
			<td><h5>Category:</h5></td>
			<td><form:select path="categoryID" name="categoryID">
					<form:options items="${cateName}" />
				</form:select></td>
			<td><h5>Facility Name:</h5></td>
			<td><input name="facName" type="text" size="15" /></td>
			<td><input type="submit" name="submit" value="submit" class="btn"/></td>
	</table>
	<table style="text-align: center;" border="1 px" class="table table-hover">
		<thead>
			<tr>
				<td>Facility ID</td>
				<td>Facility Name</td>
				<td>Category Name</td>
				<td>Status</td>
				<td>Remarks</td>
				<td>Edit/Delete</td>
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
						href="${pageContext.request.contextPath}/facility/edit/${facility.facilityID}.html">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/facility/delete/${facility.facilityID}.html">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form:form>
<%-- </form:form> --%>
<%-- </form:form>						 --%>
<a href="${pageContext.request.contextPath}/">Home page</a>
</html>