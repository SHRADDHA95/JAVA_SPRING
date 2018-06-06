
<html>
<%@include file="header.jsp"%>
<head>
<title>User details</title>
</head>
<body>



	<div class="container" id="displayResult">
		<div class="panel panel-primary">
			<div class="panel-heading">Country List</div>
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
					data-toggle="modal" data-target="#myModal">Add Country</button>
				<br></br>
				<table class="table table-striped">
					<tr>
						<th>SN</th>
						<th>Country Code</th>
						<th>Country Name</th>
						<th>Continent</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
					<c:forEach var="con" items="${country_info}" varStatus="counter">
						<tr>
							<td><c:out value="${counter.index+1}" /></td>
							<td><c:out value="${con.country_code}" /></td>
							<td><c:out value="${con.country_name}" /></td>
							<td><c:out value="${con.continent}" /></td>
							<td><button type="button" class="btn btn-success btn-sm"
									data-toggle="modal" data-target="#myModal"
									onclick="getCountryData('${con.id}','${con.country_code}','${con.country_name}','${con.continent}')">Update</button>

								<input type="hidden" name="removeCountry" id="removeCon"
								value="${con.country_code}" /></td>

							<td><button type="submit" class="btn btn-danger btn-sm"
									onClick="removeCountry('${con.id}')" data-toggle="modal"
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
				<h4 class="modal-title">Country Master</h4>
			</div>
			<div class="modal-body">
				<form:form id="modal-form"
					action="${pageContext.request.contextPath}/countryList/update"
					method="post" modelAttribute="countryInfo">
					<div class="form-group">
						<label for="id">Id:</label>
						<form:input path="id" class="form-control" id="id"
							placeholder="Enter Id " name="id" />
					</div>

					<div class="form-group">
						<label for="country_code">country_code:</label>
						<form:input path="country_code" class="form-control" id="code"
							placeholder="Enter country_code" name="code" />
					</div>

					<div class="form-group">
						<label for="dob">country_name:</label>
						<form:input path="country_name" class="form-control" id="c_name"
							placeholder="Enter country name" name="country_name" />
					</div>
					<div class="form-group">
						<label for="password">Continent:</label>
						<form:input path="continent" class="form-control" id="cont"
							placeholder="Enter continent name" name="continent" />
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
<div class="modal fade" id="confirmPrompt" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Remove Confirmation</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to remove the selected user?</p>
				<div id="message"></div>	
				<input type="hidden" name="removeCountry" id="removeCountry" />
				<button type="button" id="confirmRemove" class="btn btn-default">Yes</button>
				<button type="button" id ="confirmClose" class="btn btn-default" data-dismiss="modal">No</button>



			</div>

		</div>
	</div>
</div>

<script>
	function getCountryData(id, country_code, country_name, continent) {
		$("#id").attr("disabled", "true");
		$("#id").val(id);
		$("#code").val(country_code);
		$("#c_name").val(country_name);
		$("#cont").val(continent);
	}

	function resetForm() {

		$('#id').removeAttr("disabled");
		$("#modal-form")[0].reset();
		$('#modal-form').attr('action',
				"${pageContext.request.contextPath}/countryList/add");

	}

	function removeCountry(id) {

		$("#removeCountry").val(id);

	}

	/* $("#confirmRemove").click(
			function() {
				$.get("{pageContext.request.contextPath}/countryList/remove/"
						+ $("#removeCountry").val(), function(data, status) {
					alert("Data: " + data.successMessage + "\nStatus: "
							+ status);
				});
			}); */

	/**for flash message**/
	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 3000);

	/** jQuery function to remove a user **/
	
</script>
<script>
  	try{
  		
  		$(document).ready(function(){
  		    $("#confirmRemove").click(function(){
			
  		    	$.post("${pageContext.request.contextPath}/countryList/remove", {id : $("#removeCountry").val() }, function(response) {  		    	
  		    		var json = JSON.parse(response);
  		    		//alert("Second Alert:"+json.successMessage);
					$("#message").html("<div class='alert alert-success'><strong>Success!</strong>"+json.successMessage+"</div>");	
  				}).done(function() {
  				}).fail(function(xhr, textStatus, errorThrown) {
  				}).complete(function() {
  							
  				});
  		    });
  		});
  		
  	}catch(e){
  		alert("&&&&&&&&&&&& : "+e);
  	}
  	
  	
  	/*page reload on removal*/
 $('#confirmRemove').on('click', function() {
	
	 location.reload();
	 });
  	
 $('#.close').on('click', function() {
		
	 location.reload();
	 });
 
 $('#confirmClose').on('click', function() {
		
	 location.reload();
	 });
  	
  	
</script>


</html>