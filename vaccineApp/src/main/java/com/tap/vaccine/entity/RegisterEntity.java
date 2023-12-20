package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_table")
public class RegisterEntity {
	
	@Id
	@Column(name="REGISTER_ID")
	private int registerId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="MOBILE_NO")
	private long mobileNo;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="PASSWORD")
	private String password;
	 
	@Column(name="LOGIN_ATTEMPT")
	private int loginAttempt;
	
	@Column(name = "MEMBER_COUNT")
	private int memberCount;
	

	public RegisterEntity() {
		System.out.println("Invoked RegisterEntity()..");
	}

	public RegisterEntity(int registerId, String userName, String emailId, long mobileNo,String gender, String dateOfBirth,
			String password) {
		
		this.registerId = registerId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}
	
	public RegisterEntity(String userName,String emailId,long mobileNo,String gender,String dateOfBirth,
			String password) {
		
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}
	

	public RegisterEntity(int registerId, String userName, String emailId, long mobileNo, String gender,
			String dateOfBirth, String password, int loginAttempt, int memberCount) {
		super();
		this.registerId = registerId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.loginAttempt = loginAttempt;
		this.memberCount = memberCount;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public int getRegisterId() {
		return registerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	
	@Override
	public String toString() {
		return "("+registerId+","+userName+","+emailId+","+mobileNo+","+gender+","+dateOfBirth+","+password+","+loginAttempt+","+memberCount+")";
	}
	
	
	

}