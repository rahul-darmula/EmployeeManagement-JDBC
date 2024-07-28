package com.myjdbcpractice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StepsToImplementJDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
//			1. Loading and registering driver class
			Class.forName("com.mysql.cj.jdbc.Driver"); //throws ClassNotFoundException. //When Driver class loads it excutes refisternig code prensent in static block of Driver class
			
//			2. Creating Connection Object
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.148:3306/dbforjdbcpractice","root", "Welcome@123"); //throws SQLException
			
//			3. Creating Statement Object
			Statement st = con.createStatement(); //throws SQLException
			
//			4. Preparing Query 
			String query = "select * from employee";
			
//			5. Executing query
			ResultSet rs = st.executeQuery(query);
			
//			6. Processing the data (ResultSet)
			while(rs.next()) { //returns false when records finished
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}	
		}
		catch(java.lang.ClassNotFoundException cnfe) { //java.lang.ClassNotFoundException
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException sqle) {
				System.out.println(sqle);
			}
			
		}
		
		

	}

}
