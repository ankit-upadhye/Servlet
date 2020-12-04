package com.ankit.service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ankit.database.dbConfig;
import com.ankit.entity.LoginDetails;

public class LoginService {

	private Connection conn;
	
	public LoginService() throws ClassNotFoundException, SQLException
	{
		conn=dbConfig.connectMySql();
	}
	
	public List<LoginDetails> getDetails() throws SQLException
	{
		String query="SELECT * FROM viewLogin";
		Statement stmt=conn.createStatement();
	    List <LoginDetails>list=new <LoginDetails>ArrayList();
		ResultSet r=stmt.executeQuery(query);
		while(r.next())
		{
			LoginDetails ld=new LoginDetails(
							r.getString("username"),
							r.getString("password"));
			
			list.add(ld);
		}
		
		return list;
	}
	
	
}
