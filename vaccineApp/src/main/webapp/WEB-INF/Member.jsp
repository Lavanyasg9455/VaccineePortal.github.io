<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add_Member_Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/member.css"/>">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

</head>
<body>


	<header>
	<span>
		<a id="a" href="viewAllButton" class="btn-btn-primary">View All Members</a>&nbsp;&nbsp;&nbsp;
		<a id="a" href="getBackHomePage" class="btn-btn-primary">Back</a>
	</span>

	</header>
	
	<center>
		<h1 id=success>${memberMessage}</h1>
		<h2 id=failure>${memberErrorMessage}</h2>
	</center>

<div id="d">
<center>
	<form action="addMember" method="post">
				<h1>Add Member Form</h1><br>
				
				<input id=i1 type="text" name="memberName" id="memberName" value="" placeholder="MEMBER NAME" required class="form-control"><br>
				
				<div id="div">
				<label for="gender"  id="g" value="">Gender</label><br><br>
				<input type="radio" name="gender" id="gender" value="Female" required>&nbsp;Female &nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="Male" required>&nbsp;Male &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="Other" required>&nbsp;Other &nbsp;&nbsp;&nbsp;&nbsp;
				</div><br>
				
				
				<input id=i4 type="date" name="dateOfBirth" id="dateOfBirth" value="" required class="form-control"><br> <select id="i2" name="idProof" id="idProof" value=""
					placeholder="ID PROOF" class="form-control" required="required">
					<option value="" selected disabled>Select Governament ID</option>
					<option value="ADHAR CARD">ADHAR CARD</option>
					<option value="PAN CARD">PAN CARD</option>
					<option value="VOTER ID">VOTER ID</option>
					<option value="DRIVING LICENCE">DRIVING LICENCE</option>
				</select><br> <input id="i3" type="text" name="idProofNo" id="idProofNo" value="" placeholder="ID PROOF NUMBER" required class="form-control"><br>
				
				<select id="i5" name="vaccineType" required="required" value="" placeholder="VACCINE TYPE" class="form-control">
				<option value="" selected disabled>Select Vaccine Type</option>
						<option value="COVAXINE">COVAXINE</option>
						<option value="COVISHIELD">COVISHIELD</option>
						<option value="SPOTNIK">SPOTNIK</option>
				</select><br>
				
				<select id="i6" name="dose" required="required" value="" placeholder="DOSE" class="form-control">
						<option value="" selected disabled>Select Dose</option>
						<option value="DOSE-1">DOSE-1</option>
						<option value="DOSE-2">DOSE-2</option>
						<option value="DOSE-3">DOSE-3</option>
				</select><br>
					
				<input id="submit" type="submit" value="ADD MEMBER"><br><br>
	</form>	
</center>	
</div>
<center>
		<p class="center" style= "color:white; background-color:green; width:fit-content">${successMessage}</p>
		<p class="center" style= "color:white; background-color:red; width:fit-content">${tableErrorMessage}</p>
</center>

<table class="members-table">
		<thead>
			<tr>
				<th>MEMBER NAME</th>
				<th>GENDER</th>
				<th>DOB</th>
				<th>GOVERNMENT ID</th>
				<th>ID PROOF</th>
				<th>VACCINE TYPE</th>
				<th>DOSE</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.memberName}</td>
					<td>${member.gender}</td>
					<td>${member.dateOfBirth}</td>
					<td>${member.idProof}</td>
					<td>${member.idProofNo}</td>
					<td>${member.vaccineType}</td>
					<td>${member.dose}</td>
					<td><a id="a" href="editMember/${member.memberId}">Edit</a></td>
					<td><a id="a" href="deleteMember/${member.idProofNo}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<footer></footer>
</body>
</html>