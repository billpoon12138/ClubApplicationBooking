<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="demo" /></title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<!-- See http://twitter.github.com/bootstrap/scaffolding.html#responsive -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet" />
<dec:head />
</head>
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
	
	<%@include file="boostrapNavbar.jsp" %>

	<div id="message" class="alert alert-info">
		<!--<spring:message code="message.instructions" />-->
	</div>
	<div class="container-fluid">
		<div class="row-fluid">

			<div class="span3">
				<%@include file="boostrapMenu.jsp"%>
			</div>
			<!--/span-->
			<div class="span9">
				<!--Body content-->
			<dec:body />
			</div>

		</div>

		<hr>
		<footer >
			<p align="left">&copy; ISS NUS SA42 2016</p>
		</footer>

	</div>


</body>
</html>