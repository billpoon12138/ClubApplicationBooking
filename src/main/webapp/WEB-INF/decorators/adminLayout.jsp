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
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet">
<!-- See http://twitter.github.com/bootstrap/scaffolding.html#responsive -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet" />
<dec:head />
</head>
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<%@include file="adminNavbar.jsp" %>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<!--/span-->
			<div class="span9">
				<!--Body content-->
			<dec:body />
			</div>

		</div>
		<div class="myfooter">
		<hr>
		<footer>
			<p align="center">&copy; SA42 TEAM8 2016</p>
		</footer>
		<hr>
		</div>
	</div>


</body>
</html>