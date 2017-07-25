<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style type="text/css">
.navbar .brand {
	width:150px;
	height:50px;
}

.navbar.nav{
	left:200px;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> 
				<img class="brand" src="${pageContext.request.contextPath}/img/logo1.jpg">
				<div class="nav-collapse collapse">

					<p class="navbar-text pull-right">
						<a href="${pageContext.request.contextPath}/index/logout" class="navbar-link">Log out</a>
					</p>
					
					<p class="navbar-text pull-right">
						<a href="${pageContext.request.contextPath}/contact" class="navbar-link">Contact</a>
					</p>
					<p class="navbar-text pull-right">
					<c:if test="${not empty sessionScope.USERSESSION}">
					Hello:
					<c:out value="${sessionScope.USERSESSION.member.memberName}" /> 
					</c:if>
					</p>
					<ul class="nav">
						<li ><a
							href="${pageContext.request.contextPath}/member-index">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="${pageContext.request.contextPath}/about">Facility
						<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Search</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Booking
						<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/booking/searchm">My Booking</a></li>
								<li><a href="${pageContext.request.contextPath}/facility/searchm">Make Booking</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Member
						<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/member/edit">Personal Information</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>