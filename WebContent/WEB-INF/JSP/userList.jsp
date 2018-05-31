
<html>
<%@include file="header.jsp"%>

<head>
<title>User details</title>
</head>
<body>



	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">User Master List</div>
			<div class="panel-body">

				<c:if test="${not empty successMessage }">
					<div class="alert alert-success">
						<strong>Success!</strong>
						<c:out value="${successMessage}" />
					</div>
				</c:if>
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger">
						<strong>Danger!</strong>
						<c:out value="${errorMessage}" />
					</div>
				</c:if>

				<button type="button" class="btn btn-primary" onclick="resetForm()"
					data-toggle="modal" data-target="#myModal">Add User</button>
				<br></br>
				<table class="table table-striped">
					<tr>
						<th>SN</th>
						<th>Name</th>
						<th>Email</th>
						<th>DOB</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
					<c:forEach var="user" items="${lists}" varStatus="counter">
						<tr>
							<td><c:out value="${counter.index+1}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.DOB}" /></td>
							<td><button type="button" class="btn btn-success btn-sm"
									data-toggle="modal" data-target="#myModal"
									onclick="getUserData('${user.username}','${user.email}','${user.DOB}','${user.password}')">Update</button></td>
							<%-- <td><input type="hidden" name="removeUsername"
								id="removeUser" value="${user.username}" /> --%>
							<td><button type="submit" class="btn btn-danger btn-sm"
									onClick="removeUser('${user.username}')" data-toggle="modal"
									data-target="#confirmPrompt">Remove</button></td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>


	</div>

</body>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">User Master</h4>
			</div>
			<div class="modal-body">
				<form:form id="modal-form"
					action="${pageContext.request.contextPath}/userList/update"
					method="post" modelAttribute="userForm">
					<div class="form-group">
						<label for="username">User Name:</label>
						<form:input path="username" class="form-control" id="usr"
							placeholder="Enter user name" name="username" />
					</div>

					<div class="form-group">
						<label for="email">Email:</label>
						<form:input path="email" class="form-control" id="email"
							placeholder="Enter email id" name="email" />
					</div>

					<div class="form-group">
						<label for="dob">D.O.B:</label>
						<form:input path="DOB" class="form-control" id="dob"
							placeholder="Enter date of birth" name="DOB" />
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:password path="password" class="form-control" id="pass"
							placeholder="Enter password" name="password" />
					</div>
					<input type="hidden" name="pageId" value="1" />
					<div>
						<input type="submit" class="btn btn-default" value="Save" />
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form:form>

			</div>

		</div>
	</div>
</div>

<script>
	function getUserData(username, email, dob, pass) {
		document.getElementById("usr").value = username;
		document.getElementById("email").value = email;
		document.getElementById("dob").value = dob;
	}

	function resetForm() {
		document.getElementById("modal-form").reset();
		document.getElementById("modal-form").action = "${pageContext.request.contextPath}/register/save";

	}

	function removeUser(username) {
		document.getElementById("removeUser").value = username
	}
	
	window.setTimeout(function() {
	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 3000);
	
	

	
	
	
	
</script>

<div class="modal fade" id="confirmPrompt" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Remove Confirmation</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to remove the selected user?</p>
				<form:form id="removeForm"
					action="${pageContext.request.contextPath}/userList/remove" method="post"
					modelAttribute="userForm">
					<input type="hidden" name="username" id="removeUser" />
					<button type="submit" class="btn btn-default">Yes</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">No</button>

				</form:form>

			</div>

		</div>
	</div>
</div>

</html>