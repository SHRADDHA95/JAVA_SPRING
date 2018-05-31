<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
</head>
<body>
 	<form id="loginForm" method="post"
			modelAttribute="loginCredentials">
			<table border="0">
				<tr>
					<td colspan="4" align="center"><h2>Login</h2></td>
				</tr>
				<tr>
					<td><font face="times, serif" size="4"> User Name:</font>&nbsp;</td>
					<td><input type="text" class="form-control" id="user"
							placeholder="Enter user name" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><br> <input type="button" onclick="submitForm();"
						class="btn btn-info btn-lg btn-block" value="Login" /></td>
				</tr>

			</table>
			
		</form>

<script>
function submitForm(){
 var validator = $("#loginForm").validate({
  rules: {                   
   user: "required"  
     },  
     errorElement: "span" ,                              
     messages: {
      user: " Enter Name"
     }
 });
 if(validator.form()){ // validation perform
  $('form#loginForm').attr({action: 'login/success'});   
  $('form#loginForm').submit();
 }
}
</script>
</body>
</html>