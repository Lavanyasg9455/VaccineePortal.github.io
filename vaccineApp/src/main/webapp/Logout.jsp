<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="<c:url value="/resources/css/logout.css"/>">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<header>
		<span> <a id="a" href="getLoginPage" class="btn-btn-primary">Login</a></span>
	</header>
	<aside>
		<h1>You have logged out successfully</h1>
		<h1>Please login again...</h1>
		<h1>Thank you!</h1>
	</aside>
	<footer> </footer>
</body>
</html>