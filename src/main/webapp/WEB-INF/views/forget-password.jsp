<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1>forget password</h1>
<form method="post" 
	action="${pageContext.request.contextPath}/index/sendEmail" >
	<table>
		<tbody>
			<tr>
				<td>email account:</td>
				<td><input name="email"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Send" class="btn"/></td>

			</tr>
		</tbody>
	</table>
</form>
<a href="${pageContext.request.contextPath}/">Home page</a>
