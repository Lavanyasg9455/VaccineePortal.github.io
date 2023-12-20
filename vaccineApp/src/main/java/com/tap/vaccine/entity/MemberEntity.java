package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberr_table")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private int memberId;

	
	@Column(name = "MEMBER_NAME")
	private String memberName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;

	@Column(name = "ID_PROOF")
	private String idProof;

	@Column(name = "ID_PROOF_NO")
	private String idProofNo;

	@Column(name = "VACCINE_TYPE")
	private String vaccineType;

	@Column(name = "DOSE")
	private String dose;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;

	public MemberEntity() {
		System.out.println("Invoked MemberEntity()..");
	}
	
	public MemberEntity(int memberId, String memberName, String gender, String dateOfBirth, String idProof,
			String idProofNo, String vaccineType, String dose, String userEmail) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.userEmail = userEmail;
	}
	
	public MemberEntity(String memberName, String gender, String dateOfBirth, String idProof, String idProofNo,
			String vaccineType, String dose,String userEmail) {
		super();
		this.memberName = memberName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.userEmail = userEmail;
	}

	public MemberEntity(int memberId, String memberName, String gender, String dateOfBirth, String idProof,
			String idProofNo, String vaccineType, String dose) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}


	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "(" + memberId + "," + memberName + "," + gender + "," + dateOfBirth + "," + idProof + "," + idProofNo
				+ "," + vaccineType + "," + dose + "," + userEmail + ")";
	}

}