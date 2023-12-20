package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface ForgotPasswordDAO {
	
	RegisterEntity getRegisterEntityByEmail(String emailId);
	boolean updateNewPasswordByEmail(String emailId,String newPassword);

}