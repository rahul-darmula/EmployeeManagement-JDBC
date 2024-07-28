package com.amnetdigital;

public class Queries {
	public static String insertQuery = "insert into ademployees values(?,?,?,?)"; 
	public static String readQuery = "select * from ademployees";
	public static String updateNameQuery = "update ademployees set ename = ? where eid=?";
	public static String updateEmailQuery = "update ademployees set email = ? where eid = ?";
	public static String updateSalaryQuery = "update ademployees set salary = ? where eid = ?";
	public static String deleteQuery = "delete from employee where id = ?";
	public static String orderByNamePC = "{call getEmployeesOrderByName()}";
	public static String orderBySalDescPC = "{call getEmployeesOrderBySalDesc()}";
	public static String maxSalPC = "{call getEmployeeWithHighestSal()}";
}
