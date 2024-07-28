package com.amnetdigital;

import java.math.BigDecimal;
public class Employee {
	
	private int id;
	private String name;
	private String email;
	private BigDecimal salary;
	
	public Employee(int id, String name, String email, BigDecimal salary){
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	 public int getId() {
		 return id;
	 }
	 public String getName() {
		 return name;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public BigDecimal getSalary() {
		 return salary;
	 }
	 
	 public String toString() {
		 return id+", "+name+", "+email+", "+salary; 
	 }
}
