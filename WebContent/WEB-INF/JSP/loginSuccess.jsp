<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>Login Succeeded!</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<h3>Welcome ${loginCredentials.username}</h3>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>