package com.omega.smartqueue.daos;

import com.omega.smartqueue.model.LoginInformation;

public interface LoginInformationDAO 
{
	public void insert(LoginInformation loginInformation);
	public LoginInformation findByUsername(String username);
	/*
	public void create(LoginInformation loginInformation);
	public List<LoginInformation> select(LoginInformation loginInformation);
	public List<LoginInformation> selectByUsername(String username);
	public List<LoginInformation> selectAll();
	public void delete(LoginInformation loginInformation);
	public void deleteAll();
	*/
}
