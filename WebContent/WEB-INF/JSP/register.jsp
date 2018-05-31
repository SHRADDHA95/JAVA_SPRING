<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<form:form action="register/save" method="post"
			modelAttribute="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" class="form-control" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" class="form-control" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" class="form-control" /></td>
				</tr>
				<tr>
					<td>D.O.B(mm/dd/yyyy):</td>
					<td><form:input path="DOB" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="hidden"
						name="pageId" value="2" /><br> <input type="submit"
						class="btn btn-info btn-lg btn-block" value="Register" /></td>

				</tr>


			</table>

			<!-- 	<a href="login">Already Registered?Login here</a> -->

		</form:form>
	</div>
</html>
