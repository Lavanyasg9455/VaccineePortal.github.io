package com.tap.vaccine.dao;

import java.util.List;
import com.tap.vaccine.entity.MemberEntity;

public interface MemberDAO {

	boolean saveMemberEntity(MemberEntity entity);

	boolean idProofNoCheck(String idProofNo);

	List<MemberEntity> viewAllMembers(String userEmail);

	int updateMemberCount(String userEmail, int memberCount);

	int getMemberCount(String userEmail);

	MemberEntity getMemberEntityByID(int memberId);

	boolean deleteMemberEntityByIdProofNo(String idProofNo);

	boolean updateMemberEntity(MemberEntity entity);

	MemberEntity getMemberEntityByIdProofNo(String idProofNo);

	int decreaseMemberCount(String userEmail, int memberCount);

}