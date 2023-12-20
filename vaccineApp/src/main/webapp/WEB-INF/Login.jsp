<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<header>
	<center>
		<span>
		<a id="a" href="getSignUpPage" class="btn-btn-primary">SignUp</a>&nbsp;&nbsp;&nbsp;
		<a id="a" href="getLoginPage" class="btn-btn-primary">Login</a>
		</span>
	</center>
	</header>
	<center>
		<h2 id=failure>${loginMessage1}</h2>
		<h2 id=success>${resetPasswordMessage}</h2>
	</center>
 <div id="d">
<center>
<form action="loginPage" method="post">
<img src="<c:url value="/resources/images/Login.png"/>" style="width: 30%; max-height: 120px; margin-top: 1px;"/>

<input id="" type="email" name="emailId" id="emailId" placeholder="Email*" required class="form-control"><br>

<input id="" type="password" name="password" id="password" placeholder="Password*" required class="form-control"><br>


<div class="forgot">
	<label><input type="checkbox">&nbsp;&nbsp;Remember Me</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="getForgotPasswordPage">Forgot Password?</a>
</div><br>

	<input id="submit" type="submit" value="Login"><br><br>


	<p>Dont have account?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="getSignUpPage">SignUp Here</a></p>
</form>
</center>
</div>
<footer></footer>
</body>
</html>