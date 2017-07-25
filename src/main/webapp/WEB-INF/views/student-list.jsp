
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Student List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>Student Id</td>
<td>Student Name</td>
<td>Student Nick Name</td>
<td>Student Fee</td>
<td>Student Grade</td>
<td>Edit/Delete</td>
</thead>
<tbody>
<c:forEach var="student" items="${studentList}">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.nick}</td>
<td>${student.fee}</td>
<td>${student.grade}</td>
<td>
<a href="${pageContext.request.contextPath}/student/edit/${student.id}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/student/delete/${student.id}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
