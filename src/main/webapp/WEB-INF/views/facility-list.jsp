
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>facility List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" class="table table-hover">
<thead>
<tr>
<td>facilityID</td>
<td>facilityName</td>
<td>category</td>
<td>status</td>
<td>remarks</td>
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
<td>
<a href="${pageContext.request.contextPath}/facility/edit/${facility.facilityID}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/facility/delete/${facility.facilityID}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
