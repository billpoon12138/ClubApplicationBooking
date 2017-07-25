<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
<style>
.pic{
	width:100%;
}
.carousel{
	/*margin-top:50px;
	margin-left:300px;*/
    margin: auto;
    position: absolute;
    top: 80px; left: 0; bottom: 0; right: 0;
	width:600px;
}
ul{
	list-style-type:none;
}
body{
	background-color:#f2f2f2;
}
</style>
</head>
<body>
<div id="myCarousel" class="carousel slide" data-interval="2500">
  <ul class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ul>
  <!-- Carousel items -->
  <div class="carousel-inner">
    <div class="active item"><img src="${pageContext.request.contextPath}/img/1.jpg" alt="test" class="pic"/></div>
    <div class="item"><img src="${pageContext.request.contextPath}/img/2.jpg" alt="test" class="pic"/></div>
    <div class="item"><img src="${pageContext.request.contextPath}/img/3.jpg" alt="test" class="pic"/></div>
    <div class="item"><img src="${pageContext.request.contextPath}/img/4.jpg" alt="test" class="pic"/></div>
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
  <br></br>
  <div class="text"><p>Welcome to CAB!</p></div>
  
</div>

</body>
</html>