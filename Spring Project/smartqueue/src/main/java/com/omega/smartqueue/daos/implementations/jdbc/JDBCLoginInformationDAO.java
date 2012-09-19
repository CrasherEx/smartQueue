package com.omega.smartqueue.daos.implementations.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.LoginInformationDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.LoginInformationRowMapper;
import com.omega.smartqueue.model.LoginInformation;

public class JDBCLoginInformationDAO implements LoginInformationDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void create(LoginInformation loginInformation)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update("INSERT INTO logininfo (username, password) VALUES(?,?)",
	    		new Object[] { loginInformation.getUsername(), loginInformation.getPassword() });
	}

	@SuppressWarnings("unchecked")
	public List<LoginInformation> select(LoginInformation loginInformation)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT username, password FROM logininfo WHERE username = ? AND password = ?",
	            new Object[] { loginInformation.getUsername(), loginInformation.getPassword() },
	            new LoginInformationRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginInformation> selectByUsername(String username)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT username, password FROM logininfo WHERE username = ?",
	            new Object[] { username },
	            new LoginInformationRowMapper());	
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginInformation> selectAll()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT username, password FROM logininfo",
	            new Object[] {},
	            new LoginInformationRowMapper());	
	}

	public void delete(LoginInformation loginInformation)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("DELETE FROM logininfo WHERE username= ? AND password = ?",
	        new Object[] { loginInformation.getUsername(), loginInformation.getPassword() });
	}
	
	public void deleteAll()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("DELETE FROM logininfo");
	}


}
