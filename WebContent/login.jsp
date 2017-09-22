<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>

	function validateLogin() {
		var email = document.getElementById("email").value;
		var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (!regEx.test(email)) {
			alert("Incorrect Email Id")
			return false;
		}
		var password = document.getElementById("password").value;
		if (password.length < 8) {
			alert("Password must be at least 8 characters long");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
				<div class="panel panel-primary">

					<div class="well" style="background-color: skyblue">Sign in.</div>
					<div class="panel-body">
						<div class="row">
							<div
								class="col-xs-6 col-sm-6 col-md-6 separator social-login-box">

								<div>You can also sign in using Facebook account and
									Twitter account</div>
								<br /> <a href="http://www.facebook.com"
									class="btn facebook btn-block" role="button">Sign in using
									Facebook</a> <br /> <a href="http://www.Twitter.com"
									class="btn twitter btn-block" role="button">Sign in using
									Twitter</a>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 login-box">

								<form method="post" name="submit" action="Login"
									 class="form-horizontal"
									role="form">
									<center>Using your account</center>
									<div class="form-group">
										<label class="control-label" for="email"></label> <input
											id="email" type="email" name="email"
											placeholder="Enter your email" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label" for="password"></label> <input
											id="password" type="password" name="password"
											placeholder="Enter your password" class="form-control">
									</div>
									<div class="form-group">
										<button id="submit" type="submit" onClick="return validateLogin()" class="btn btn-success btn-block">Sign in.</button>
									</div>
									<p>
										. <a href="login.jsp">Forget your password?</a>
									</p>
									Don't have an account? <a  href="registrationform.jsp">Sign
										up here</a>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>