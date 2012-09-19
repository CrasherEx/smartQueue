package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.LoginInformation;

public interface LoginInformationDAO 
{
	public void create(LoginInformation loginInformation);
	public List<LoginInformation> select(LoginInformation loginInformation);
	public List<LoginInformation> selectByUsername(String username);
	public List<LoginInformation> selectAll();
	public void delete(LoginInformation loginInformation);
	public void deleteAll();
}
