<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/addAccount.css">
<link rel="stylesheet" href="css/homepage.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function validetaAddAccount() {

		var name = document.getElementById("name").value;
		if (name.length < 3) {
			alert("Name is too short");
			return false;
		}
		console.log("Before email");
		var email = document.getElementById("email").value;
		var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (!regEx.test(email)) {
			alert("Please enter valid emailId")
			return false;
		}

		var city = document.getElementById("city").value;
	    if (city.selectedIndex < 1)
	    {
	        alert("Please tell us how we can help you.");
	        city.focus();
	        return false;
	    }

		var number = document.getElementById("accountnumber").value;
		if (isNaN(number)) {
			alert("Invalid contact number");
			return false;
		}
		if (number.toString().length != 13) {
			alert("Contact number must have 13 digits");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="alert alert-success" style="background-color: skyblue;">
		<label> <a><%=session.getAttribute("name")%></a></label> <a
			id="button" href="LogoutAccount"
			style="float: right; margin-top: -5px;"
			class="btn btn-primary btn-md">Logout</a>
	</div>
	<div class="container">
		<div class="row">
			<div class="btn-group-vertical col-sm-3">
				<button type="button" class="btn btn-primary btn-lg"
					onclick="displayCityData('Bangalore')">Bangalore</button>
				<br>
				<button type="button" class="btn btn-primary btn-lg"
					onclick="displayCityData('Mumbai')">Mumbai</button>
				<br>
				<button type="button" class="btn btn-primary btn-lg"
					onclick="displayCityData('Delhi')">Delhi</button>
			</div>

			<div>
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal"
					style="margin-top: 485px; float: right">+ Add</button>
			</div>

			<div class="modal fade" id="myModal" role="dialog"
				style="z-index: 1060">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add Account</h4>
						</div>
						<form method="POST"  action="AddAccountDetails" role="form">
							<div class="form-group">
								<label class="control-label" for="email">Enter the name</label>
								<input id="name" name="name" type="text"
									placeholder="Enter the name" class="form-control">
							</div>
							<div class="form-group">
								<label class="control-label" for="name">Enter the email</label>
								<input id="email" name="email" type="email" class="form-control"
									placeholder="Enter the email">
							</div>
							<div class="form-group">
								<label class="control-label" for="city">Select any city</label>
								<div>
									<select name="city" class="form-control">
										<option selected disabled>City</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Delhi">Delhi</option>
										<option value="Bangalore">Bangalore</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="acconut">Enter account
									number</label> <input id="accountnumber" name="accountnumber"
									type="text" placeholder="Enter account number"
									class="form-control">
							</div>

							<div class="form-group">
								<button id="submit" type="submit" name="submit"
									class="btn btn-success" onclick="return validetaAddAccount()" >Add</button>
								<button id="close" type="button" name="close"
									class="btn btn-success om" data-dismiss="modal">Close</button>
							</div>
						</form>

					</div>
				</div>
			</div>

			<div class="modal fade" id="cityModal" role="dialog"
				style="z-index: 1050">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" id="city-title">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"></h4>
						</div>

						<div class="modal-body" id="details-table"></div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			var city = "";
			var id;
			console.log("Starting javascript");
		});

		function displayCityData(city) {
			console.log("inside javascript");
			$.ajax({
				type : 'POST',
				url : 'AccountView',
				data : {
					city : city
				},
				success : function(result) {
					console.log("ajax success");
					console.log(result);
					$('#details-table').html(result);
					$('#body-of-modal').html(result);
					$('#cityModal').modal('show');
				}
			});
		}

		function deleteAccount(id) {
			console.log("Inside deleteAccount javascript");
			$.ajax({
				url : 'DeleteAccount',
				type : 'POST',
				data : {
					id : id
				},
				success : function(result) {
					console.log("deleteaccount");
					$("#email").html(result);
					$('#deleteAccount').modal('show');
				}
			});
		}

		function updateAccount(id) {
			console.log("Inside UpdateAccount javascript");
			$.ajax({
				url : 'UpdateAccount',
				type : 'POST',
				data : {
					id : id
				},
				success : function(result) {
					console.log("Update account")
					$("#name").html(result.name);
					$("#email").html(result.email);
					$("#city").html(result.city);
					$("#accountnumber").html(result.accountnumber);
					$('#updateAccount').modal('show');
				}
			});
		}
	</script>
</body>
</html>