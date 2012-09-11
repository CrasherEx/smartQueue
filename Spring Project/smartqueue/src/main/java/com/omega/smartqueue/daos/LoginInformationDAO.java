package com.omega.smartqueue.daos;

import com.omega.smartqueue.model.LoginInformation;

public interface LoginInformationDAO 
{
	public void insert(LoginInformation loginInformation);
	public LoginInformation findByUsername(String username);
}
