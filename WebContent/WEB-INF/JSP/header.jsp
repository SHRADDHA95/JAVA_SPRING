
<%@include file="linkRepo.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring MVC POC</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<c:if test="${not empty sessionScope.userKey}">
				<li><a href="${pageContext.request.contextPath}/userList">Users</a></li>
				<li><a href="${pageContext.request.contextPath}/countryList"><span
						class="glyphicon glyphicon-globe"></span>&nbsp;Country</a></li>

			</c:if>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty sessionScope.userKey}">
				<li><a href="${pageContext.request.contextPath}/"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.userKey}">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<c:out value="${sessionScope.userKey.username}"></c:out> </a></li>
				<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-log-out"></span> Log out</a></li>
			</c:if>
		</ul>
	</div>
</nav>
