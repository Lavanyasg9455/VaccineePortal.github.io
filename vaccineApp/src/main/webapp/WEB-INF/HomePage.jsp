<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaccine Registration Form</title>
<link rel="stylesheet" href="<c:url value="/resources/css/homePage.css"/>">
</head>
<body>
	<form>
		<header>
		
		<script>
			function go() {
				window.location.replace("Logout.jsp",'window','toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
				self.close()
			}
		</script>
			<span> <a class="a" id="l" href="logout" class="btn-btn-primary">Back</a>&nbsp;&nbsp;&nbsp; 
			<a class="a" id="l" href="getAddMemberPage" class="btn-btn-primary">AddMember</a>
			
			
			<%
				String str = request.getParameter("userEmail");
				session.setAttribute("EMAIL", request.getParameter("userEmail"));
			%>
			<h5 id="p1">User:<%=session.getAttribute("userEmail")%></h5>
			<%
				if (session.getAttribute("userEmail").equals("")) {
			%>
				<a id="a" href="getLoginPage" class="btn-btn-primary">Login</a>
			<%
				} else {
			%>
				<a class="a" id="r" href="javascript:go()" class="btn-btn-primary">Logout</a>
			<%
				}
			%>
			</span>
		</header>

		<aside>
			<span id=span1>
				<div class="card" style="background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);">
					<div class="container">
						<h4 style="margin-top:40px; color:#43d7ff;font-size:18px;">
							<b>Registration Count</b>
						</h4>
						<img src="<c:url value="/resources/images/login-family.svg"/>" style="width: 100%; max-height: 150px; margin-top: 5px;"/>
						<h1 style="font-size: 150px; margin-top: 5px; color: #43d7ff; text-align: center; margin: 0;">${memCount}</h1>
						
					</div>
				</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<div class="card" style="background:#FF9800;">
					<div class="container">
					<img src="<c:url value="/resources/images/card_image.svg"/>" style="width: 100%; max-height: 150px; margin-top: 5px;"/>
						<h4 style="margin-top:40px;font-size:20px;color:black;">
							<b>Naruto</b>
						</h4>
						<p style="margin-top:30px;font-size:20px;color:black;">Software Intern</p>
					</div>
				</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<div class="card" style="background:#88AB8E;">
					<div class="container">
					<img src="<c:url value="/resources/images/card_image.svg"/>" style="width: 100%; max-height: 150px; margin-top: 5px;"/>
						<h4 style="margin-top:40px; color:black;font-size:20px;">
							<b>Hinata</b>
						</h4>
						<p style="margin-top:40px; color:black;font-size:20px;">Developer</p>
					</div>
				</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<div class="card" style="background:#A367B1;">
					<div class="container">
					<img src="<c:url value="/resources/images/card_image.svg"/>" style="width: 100%; max-height: 150px; margin-top: 5px;"/>
						<h4 style="margin-top:40px; color:black;font-size:20px;">
							<b>Itachi</b>
						</h4>
						<p style="margin-top:40px; color:black;font-size:20px;">Team Leader</p>
					</div>
				</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<div class="card" style="background:#C5FFF8;">
					<div class="container">
					<img src="<c:url value="/resources/images/card_image.svg"/>" style="width: 100%; max-height: 150px; margin-top: 5px;"/>
						<h4 style="margin-top:40px; color:black;font-size:20px;">
							<b>Xiraya</b>
						</h4>
						<p style="margin-top:40px; color:black;font-size:20px;">Full Stack Developer</p>
					</div>
				</div>
			</span>
		</aside>

		<footer></footer>
	</form>
</body>
</html>