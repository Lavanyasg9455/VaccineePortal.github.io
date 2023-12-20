<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Member Details</title>
<link rel="stylesheet" href="<c:url value="/resources/css/updateMember.css"/>">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>


	<header>
	<span> <a id="a" href="getAddMemberPage" class="btn-btn-primary">Back</a></span>
	</header>
	
	<center>
		<h2 id="failure">${updateErrorMessage}</h2>
	</center>

<div id="d">
<center>
	<h1>Edit Member Details</h1><br>
    <form action="updateMember/${memberId}" method="post">
    
				
				<input id=i1 type="text" name="memberName" id="memberName" value="${NAME}" placeholder="MEMBER NAME" required class="form-control"><br>
				
				<div id="div">
				<label for="gender"  id="g">Gender</label><br><br>
				<input type="radio" name="gender" id="gender" value="female" required <c:if test="${GENDER eq 'Female'}">checked</c:if>>&nbsp;Female &nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="male" required <c:if test="${GENDER eq 'Male'}">checked</c:if>>&nbsp;Male &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="gender" value="other" required <c:if test="${GENDER eq 'Other'}">checked</c:if>>&nbsp;Other &nbsp;&nbsp;&nbsp;&nbsp;
				</div><br>
				
				
				<input id=i4 type="date" name="dateOfBirth" id="dateOfBirth" value="${DATE_OF_BIRTH}" required class="form-control"><br> 
				
				<select id="i2" name="idProof" id="idProof" value="${ID_PROOF}" placeholder="ID PROOF" class="form-control" required="required">
					<option value="" selected disabled>Select Governament ID</option>
					<option value="ADHAR CARD" <c:if test="${ID_PROOF eq 'ADHAR CARD'}">selected</c:if>>ADHAR CARD</option>
					<option value="PAN CARD" <c:if test="${ID_PROOF eq 'PAN CARD'}">selected</c:if>>PAN CARD</option>
					<option value="VOTER ID" <c:if test="${ID_PROOF eq 'VOTER ID'}">selected</c:if>>VOTER ID</option>
					<option  value="DRIVING LICENCE" <c:if test="${ID_PROOF eq 'DRIVING LICENCE'}">selected</c:if>>DRIVING LICENCE</option>
				</select><br>
				
				<input id="i3" type="text" name="idProofNo" id="idProofNo" value="${ID_PROOF_NO}" placeholder="ID PROOF NUMBER" required class="form-control"><br>
				
				<select id="i5" name="vaccineType" required="required" value="${VACCINE_TYPE}" placeholder="VACCINE TYPE" class="form-control">
				<option value="" selected disabled>Select Vaccine Type</option>
						<option value="COVAXINE" <c:if test="${VACCINE_TYPE eq 'COVAXINE'}">selected</c:if>>COVAXINE</option>
						<option value="COVISHIELD" <c:if test="${VACCINE_TYPE eq 'COVISHIELD'}">selected</c:if>>COVISHIELD</option>
						<option  value="SPUTNIK" <c:if test="${VACCINE_TYPE eq 'SPUTNIK'}">selected</c:if>>SPUTNIK</option>
				</select><br>
				
				<select id="i6" name="dose" required="required" value="${DOSE}" placeholder="DOSE" class="form-control">
						<option value="" selected disabled>Select Dose</option>
						<option value="DOSE-1" <c:if test="${DOSE eq 'DOSE-1'}">selected</c:if>>DOSE-1</option>
						<option value="DOSE-2" <c:if test="${DOSE eq 'DOSE-2'}">selected</c:if>>DOSE-2</option>
						<option value="DOSE-3" <c:if test="${DOSE eq 'DOSE-3'}">selected</c:if>>DOSE-3</option>
				</select><br>
					
				<input id="submit" type="submit" value="Update Member"><br><br>
	</form>	
</center>	
</div>
<footer></footer>
</body>
</html>