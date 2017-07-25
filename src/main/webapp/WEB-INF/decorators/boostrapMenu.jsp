<html>
<body>
  <!--  This one is a show off that spring message can replace fmt tags ;-)  -->    
    <div class="well sidebar-nav">
        <ul class="nav nav-list">
       
            <li class="nav-header"><spring:message code="menu.home" /> </li>
            <li><a href="${pageContext.request.contextPath}/about"><spring:message code="menu.item1" /></a></li>
            <li><a href="${pageContext.request.contextPath}/contact"><spring:message code="menu.item2" /></a></li>
            <li><a href="${pageContext.request.contextPath}/index"><spring:message code="menu.item3" /></a></li>
        </ul>
    </div>

</body>
</html>