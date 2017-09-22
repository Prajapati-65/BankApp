<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/registrationform.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
<script>

function validateRegistration(){
	var name = document.getElementById("name").value;
	if(name.length < 3){
		alert("Name is too short");
		return false;
	}
	console.log("Before email");
	var email = document.getElementById("email").value;
	var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!regEx.test(email)){
    	alert("Please enter valid emailId")
    	return false;
    }
	
	var password = document.getElementById("password").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	
	var contact = document.getElementById("mobilenumber").value;
	if(isNaN(contact)){
		alert("Invalid contact number");
		return false;
	}
	if(contact.toString().length != 10){
		alert("Contact number must have 10 digits");
		return false;
	}
	
	return true;
}

</script>
	
	
</head>
<body>
	<div class="container">
		<div class="row"">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form method="post" action="Registration"  name="submit" onClick="return validateRegistration()">
						<div class="form-group">
							<h2>Create an Account</h2>
						</div>
						<div class="form-group">
							<label class="control-label" for="name">Enter the name</label> <input
								id="name" name="name" type="text" class="form-control"
								placeholder="Enter the name">
						</div>
						<div class="form-group">
							<label class="control-label" for="email">Enter the email</label>
							<input id="email" name="email" type="email"
								placeholder="Enter the email" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Enter the
								password</label> <input id="password" name="password" type="password"
								placeholder="Enter the password" class="form-control">
						</div>
						
						<div class="form-group">
							<label class="control-label" for="number">Enter mobile
								number</label> <input id="mobilenumber" name="mobilenumber" type="text"
								placeholder="Enter mobile number" class="form-control">
						</div>

						<div class="form-group">
							<button id="submit" type="submit"
								class="btn btn-success btn-block">Create my Account</button>
						</div>
						<p class="form-group">
							By clicking on the "Create my Account button "bellow you certify
							that you have read and agree to our <a href="#">Terms of Use</a>
							and our <a href="#">Privacy Policy</a>.
						</p>
						Create an account? <a href="login.jsp">Sign in</a>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>