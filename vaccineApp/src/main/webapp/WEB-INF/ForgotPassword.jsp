<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/forgotPassword.css"/>">
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
		<h2 id=failure>${errorPasswordMessage}</h2>
	</center>
<div id="d">
<center>
<form action="forgotPasswordPage">
      <h1>Forgot Password</h1><br>

<input id="" type="email" name="emailId" id="emailId" placeholder="EmailId" required class="form-control">
<p>Note: Enter The Registered EmailId</p>

<input id="" type="password" name="newPassword" id="newPassword" placeholder="New Password" required class="form-control"><br>

<input id="" type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required class="form-control"><br>

<input id="submit" type="submit" value="Reset Password"><br><br>
	
</form> 
</center>
</div>
<footer></footer>
</body>
</html>