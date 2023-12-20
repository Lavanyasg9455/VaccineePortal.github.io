<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration_Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/register.css"/>">
<script type="text/javascript" src="<c:url value="/resources/script/register.js"/>"></script>
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
		<h2>${registerResponse1}</h2>
		<h1>${registerResponse}</h1>
	</center>
<div id="d">
<center>
	<form action="saveRegister" onsubmit="return validate()">
				<h1>Registration Form</h1><br>
				
				<input id="i1" type="text" name="userName" id="userName" value="" placeholder="USERNAME" required class="form-control">
				<span id="msg" style="color:red;"></span>
				
				<input id="i2" type="email" name="emailId" id="emailId" value="" placeholder="EMAIL" required class="form-control">
				<span id="msg2" style="color:red;"></span>
				
				<input id="i3" type="number" name="mobileNo" id="mobileNo" value="" placeholder="MOBILE NUMBER" required class="form-control">
				<span id="msg1" style="color:red;"></span>
				
				<div id="div">
				<label for="gender"  id="g">Gender</label><br><br>
				<input type="radio" name="gender" id="gender" value="Female" required>&nbsp;Female &nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="Male" required>&nbsp;Male &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="Other" required>&nbsp;Other &nbsp;&nbsp;&nbsp;&nbsp;
				</div><br>
				
				
				<input id="i4" type="date" name="dateOfBirth" id="dateOfBirth" value="" required class="form-control"><br>
				<span id="msg5" style="color:red;"></span><br><br>
				
				<input id="i5" type="password" name="password" id="password" value="" placeholder="PASSWORD" required class="form-control">
				<span id="msg3" style="color:red;"></span>
				
				<input id="i6" type="password" name="confirmPassword" id="confirmPassword" value="" placeholder="CONFIRM PASSWORD" required class="form-control">
				<span id="msg4" style="color:red;"></span><br><br>
					
				<input id="submit" type="submit" value="SignUp"><br><br>
				
	<p>Already have account? &nbsp;&nbsp;<a href="getLoginPage">Login here</a></p><br>
	</form>	
</center>	
</div>

<footer></footer>
</body>
</html>