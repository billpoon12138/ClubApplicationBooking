<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>New Student page</h1>
<form:form method="POST" commandName="student" action="${pageContext.request.contextPath}/student/create.html" >
<table>
<tbody>
<tr>
<td>Student Name:</td>
<td><form:input path="name" /></td>
<td><form:errors path="name" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Student Nick Name:</td>
<td><form:input path="nick" /></td>
<td><form:errors path="nick" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Student Fee:</td>
<td><form:input path="fee" /></td>
<td><form:errors path="fee" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Student Grade:</td>
<td><form:input path="grade" /></td>
<td><form:errors path="grade" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
