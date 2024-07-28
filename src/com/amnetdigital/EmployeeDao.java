package com.amnetdigital;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.math.BigDecimal;
public class EmployeeDao {
	public static void createEmployee(Employee emp) throws ClassNotFoundException, SQLException{
		
		Connection con = DB.connect();
		PreparedStatement ps = con.prepareStatement(Queries.insertQuery);
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setString(3, emp.getEmail());
		ps.setBigDecimal(4, emp.getSalary());
		
		ps.executeUpdate();
		ps.close();
		
	}
	public static ArrayList<Employee> readAllEmployees() throws ClassNotFoundException, SQLException{
		
		ArrayList<Employee> empList = new ArrayList<>();
		Connection con = DB.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Queries.readQuery);
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
			empList.add(emp);
		}
		return empList;
		
	}
	public static void updateName(int id, String name) throws ClassNotFoundException, SQLException{
		Connection con = DB.connect();
		PreparedStatement ps = con.prepareStatement(Queries.updateNameQuery);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();	
		ps.close();
	}
	public static void updateEmail(int id, String email) throws ClassNotFoundException, SQLException {
		Connection con = DB.connect();
		PreparedStatement ps = con.prepareStatement(Queries.updateEmailQuery);
		ps.setString(1, email);
		ps.setInt(2, id);
		ps.executeUpdate();	
		ps.close();
	}
	public static void updateSalary(int id, BigDecimal salary) throws ClassNotFoundException, SQLException {
		Connection con = DB.connect();
		PreparedStatement ps = con.prepareStatement(Queries.updateSalaryQuery);
		ps.setBigDecimal(1, salary);
		ps.setInt(2, id);
		ps.executeUpdate();	
		ps.close();
	}
	public static void deleteEmployee(int id) throws ClassNotFoundException, SQLException{
		Connection con = DB.connect();
		PreparedStatement ps = con.prepareStatement(Queries.deleteQuery);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		
	}
	public static ArrayList<Employee> orderByName()throws ClassNotFoundException, SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection con = DB.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Queries.orderByNamePC);
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
			empList.add(emp);
		}
		return empList;
	}
	public static ArrayList<Employee> getEmployeesOrderBySalDesc()throws ClassNotFoundException, SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection con = DB.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Queries.orderBySalDescPC);
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
			empList.add(emp);
		}
		return empList;
	}
	public static String getEmpWithMaxSalary() throws ClassNotFoundException, SQLException{
		Connection con = DB.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Queries.maxSalPC);
		String name = "";
		while(rs.next()) {
			name = rs.getString(1);
		}
		return name;
	}
}
