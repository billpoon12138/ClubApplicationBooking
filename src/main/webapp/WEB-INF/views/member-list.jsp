
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>member List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>member Id</td>
<td>member Name</td>
<td>member Nick Name</td>
<td>member Fee</td>
<td>member Grade</td>
<td>Edit/Delete</td>
</thead>
<tbody>
<c:forEach var="member" items="${memberList}">
<tr>
<td>${member.userID}</td>
<td>${member.memberName}</td>
<td>${member.nricNo}</td>
<td>${member.joinDate}</td>
<td>${member.email}</td>
<td>
<a href="${pageContext.request.contextPath}/member/edit/${member.userID}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/member/delete/${member.userID}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
