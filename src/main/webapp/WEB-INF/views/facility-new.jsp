<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1>New Facility page</h1>
<form:form method="POST" commandName="facility"
	action="${pageContext.request.contextPath}/facility/create.html">
	<table>
		<tbody>
			<tr>
				<td>FacilityName:</td>
				<td><form:input path="facilityName" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<form:select path="categoryID" >
						<form:options items="${categoryNames}"></form:options>
					</form:select>
				</td>
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
