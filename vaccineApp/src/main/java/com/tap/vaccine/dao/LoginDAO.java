package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface LoginDAO {
	
	RegisterEntity getRegisterEntityByEmail(String emailId);

	boolean updateLoginAttempt(String emailId, int loginAttempt);

}