<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>About page</title>
<style>
.blist{
	margin:aotu;
	position:absolute;
	left:0;
	right:0;
	top:100px;
	bottom:0;
	margin-left:30px;
	margin-right:30px;
}

</style>
</head>
<body>
<div class="blist">
<h1>booking List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" class="table table-hover">
<thead>
<tr>
<td>bookingID</td>
<td>memberName</td>
<td>facilityName</td>
<td>bookingDate</td>
<td>Status</td>
<td>Edit/Delete</td>
</tr>
</thead>
<tbody>
<c:forEach var="booking" items="${bookingDTOList}">
<tr>
<td>${booking.bookingID}</td>
<td>${booking.memberName}</td>
<td>${booking.facilityName}</td>
<td>${booking.bookingDate}</td>
<td>${booking.bookingStatus}</td>
<td>
<a href="${pageContext.request.contextPath}/booking/edit/${booking.bookingID}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/booking/delete/${booking.bookingID}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</div>
</body>
</html>


