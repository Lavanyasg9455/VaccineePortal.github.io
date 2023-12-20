package com.tap.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.controller.LoginController;
import com.tap.vaccine.dao.MemberDAO;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.exception.InvalidMemberCredentials;

@Component
public class MemberService {
	
	private MemberDAO memberDAO;

	@Autowired
	public MemberService(MemberDAO memberDAO) {

		System.out.println("Invoked MemberDAO()..");
		this.memberDAO = memberDAO;
	}
	
	String email = LoginController.userEmail;
	
	public boolean validateMemberData(String memberName,String gender,String dateOfBirth,
			String idProof,String idProofNo,String vaccineType,String dose) throws InvalidMemberCredentials{
		
		System.out.println("Invoked validateMemberData()..");
		boolean validmemberName=false;
		boolean validgender=false;
		boolean validdateOfBirth=false;
		boolean valididProof=false;
		boolean valididProofNo=false;
		boolean validvaccineType=false;
		boolean validdose=false;
		
		if(memberName!=null && !memberName.isEmpty() && !memberName.isBlank()) {
			System.out.println("memberName is valid..");
			validmemberName=true;
		}else {
			throw new InvalidMemberCredentials("Enter Valid memberName");
		}
		
		if(gender!=null && !gender.isEmpty() && !gender.isBlank()) {
			System.out.println("gender is valid..");
			validgender=true;
		}else {
			throw new InvalidMemberCredentials("Select Valid Gender ");
		}
		
		if(dateOfBirth!=null && !dateOfBirth.isEmpty() && !dateOfBirth.isBlank()) {
			System.out.println("dateOfBirth is valid..");
			validdateOfBirth=true;
		}else {
			throw new InvalidMemberCredentials("Enter Valid Date Of Birth");
		}
		
		if (idProof != null && !idProof.isEmpty() && !idProof.isBlank()) {
			System.out.println("idProof is valid..");
			valididProof = true;
		} else {

			throw new InvalidMemberCredentials("Select Valid idProof");

		}
		
		if(idProofNo!=null && !idProofNo.isEmpty() && !idProofNo.isBlank()) {
			System.out.println("idProofNo is valid..");
			valididProofNo=true;
		}else {
			throw new InvalidMemberCredentials("Enter Valid Id Proof Number");
		}
		
		if(vaccineType!=null && !vaccineType.isEmpty() && !vaccineType.isBlank()) {
			System.out.println("vaccineType is valid..");
			validvaccineType=true;
		}else {
			throw new InvalidMemberCredentials("Select Valid vaccineType");
		}
		
		if(dose!=null && !dose.isEmpty() && !dose.isBlank()) {
			System.out.println("dose is valid..");
			validdose=true;
		}else {
			throw new InvalidMemberCredentials("Select Valid dose");
		}
		
		return validmemberName && validgender && validdateOfBirth && valididProof && valididProofNo && validvaccineType && validdose;
		
	}
	
	public boolean saveMemberDetails(String memberName,String gender,String dateOfBirth,
			String idProof,String idProofNo,String vaccineType,String dose,String userEmail) {
		
		System.out.println("Invoked saveMemberDetails()..");
		MemberEntity entity=new MemberEntity(memberName,gender,dateOfBirth,idProof,idProofNo,vaccineType,dose,userEmail);
		return memberDAO.saveMemberEntity(entity);
		
	}
	
	public boolean idProofNoValid(String idProofNo){
		System.out.println("Invoked idProofNoValid()..");
		return memberDAO.idProofNoCheck(idProofNo);
	}
	
	public int getMemberCount(String userEmail) {
		System.out.println("Invoked getMemberCount()..");
		return memberDAO.getMemberCount(userEmail);
	}
	
	public boolean checkMemberCount(String userEmail) {
		System.out.println("Invoked checkMemberCount()..");
		boolean flag = false;
		final int maxMemberCount = 4;
		int memberCount = memberDAO.getMemberCount(userEmail);
		if(memberCount<maxMemberCount)
		{
			flag = true;
		}
		return flag;
	}
	
	public int updateMemberCount(String userEmail, int memberCount) {
		System.out.println("Invoked updateMemberCount()..");
		return memberDAO.updateMemberCount(userEmail, memberCount);
	}
	
	public List<MemberEntity> getAllMembers(String userEmail){
		
		if(memberDAO.viewAllMembers(userEmail).size()==0) {
			return null;
		}else {
			return memberDAO.viewAllMembers(userEmail);
		}

	}
	
	public MemberEntity getMemberEntityByID(int memberId) {

		System.out.println("Invoked getAirportEntityByID().. ");
		return memberDAO.getMemberEntityByID(memberId);

	}
	
	public MemberEntity getMemberEntityByIdProofNo(String idProofNo) {

		System.out.println("Invoked getMemberEntityByIdProofNo().. ");
		return memberDAO.getMemberEntityByIdProofNo(idProofNo);

	}
	
	public boolean deleteMemberEntityByIdProofNo(String idProofNo){

		System.out.println("Invoked deleteAirportEntityByID()..");
		return memberDAO.deleteMemberEntityByIdProofNo(idProofNo);
		
	}
	
	public boolean updateMemberEntity(int memberId, String memberName, String gender, String dateOfBirth,
			String idProof, String idProofNo, String vaccineType, String dose, String userEmail)
			throws InvalidMemberCredentials {
		System.out.println("Invoked updateAirportEntity()..");

		MemberEntity entity = new MemberEntity(memberId,memberName, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose,
				userEmail);
		return memberDAO.updateMemberEntity(entity);

	}
	
	public int decreaseMemberCount(String userEmail, int memberCount) {
		return memberDAO.decreaseMemberCount(userEmail, memberCount);
	}
	

}