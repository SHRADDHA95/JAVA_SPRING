<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container" align="center">
	  	<form:form action="login/success" id="loginForm" method="post"
			modelAttribute="loginCredentials">
			<table border="0">
				<tr>
					<td colspan="4" align="center"><h2>Login</h2></td>
				</tr>
				<tr>
					<td><font face="times, serif" size="4"> User Name:</font>&nbsp;</td>
					<td><form:input path="username" class="form-control" id="user"
							placeholder="Enter user name" /></td>
				</tr>
				<tr>
					<td><font face="times, serif" size="4"> Password:</font></td>
					<td><form:password path="password" class="form-control"
							id="pass" placeholder="Enter password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br> <input type="submit"
						class="btn btn-info btn-lg btn-block" value="Login" /></td>
				</tr>

			</table>

		</form:form> 
		
		</div>
</body>
</html>
