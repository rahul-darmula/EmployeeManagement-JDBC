package com.amnetdigital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
public class DB {
	public static Connection connect() throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amnetdigitaldb", "root", "Welcome@123");
		return con;
	}
}
