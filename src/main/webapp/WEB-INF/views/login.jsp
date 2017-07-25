<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.list{
	
	margin-left:40%;
}
.r{
	margin:30px;
	cellspacing:10px;
}
</style>
</head>
<body>
<tr><p>${WrongMessage}</p></tr>
<div class="list">
<form:form modelAttribute="member" method="POST" action="${pageContext.request.contextPath}/index/authenticate" >
	<table>
		<tr>
			<td>userID</td>
			<td><form:input path="userID" size="40" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><form:password path="password" size="40" /></td>
		</tr>
		<tr>
		<td>
			<a href="${pageContext.request.contextPath}/member/create">New Member</a>
		</td>
		<td class="r" >
			<a href="${pageContext.request.contextPath}/forget-password">Forget Password</a>
		</td>
		</tr>
		<tr>
			<td>
			<form:button name="submit" type="submit" class="btn">
					Login
				</form:button></td>
			<td class="r">
			<form:button name="clear" type="reset" class="btn">
					Reset
				</form:button>
			</td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>