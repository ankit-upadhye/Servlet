package com.ankit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConfig {

	public static Connection connectMySql() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form?useUnicode=true&useJDBCComplaintTimeZoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC","root","");
		return conn;
	}
}
