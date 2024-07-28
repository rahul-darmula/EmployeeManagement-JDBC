package com.amnetdigital;

import java.util.Scanner;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
public class App{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Employee Management");
			System.out.println("1.create(insert) 2.read 3.update 4.delete 5.operations");
			int choice = sc.nextInt();
			switch(choice){
				case 1: System.out.println("id, name, email, salary");
					int id = sc.nextInt();
					sc.nextLine();
					String name = sc.nextLine();
					String email = sc.nextLine();
					BigDecimal salary = sc.nextBigDecimal();
					Employee emp = new Employee(id, name, email, salary);
					EmployeeDao.createEmployee(emp);
					break;
				case 2: System.out.println("id, name, email, salary");
						ArrayList<Employee> empList = EmployeeDao.readAllEmployees();
						display(empList);
						break;
				case 3: 
					while(true) {
						System.out.println("1.update name 2.update email 3.update salary 4.back");
						choice = sc.nextInt();
						if(choice==4) break;
						switch(choice) {
							case 1:	System.out.println("id, name");
									id = sc.nextInt();
									sc.nextLine();
									name = sc.nextLine();
									EmployeeDao.updateName(id, name);
									break;
							case 2: System.out.println("id, email");
									id = sc.nextInt();
									sc.nextLine();
									email = sc.nextLine();
									EmployeeDao.updateEmail(id, email);
							case 3: System.out.println("id, email");
									id = sc.nextInt();
									sc.nextLine();
									salary = sc.nextBigDecimal();
									EmployeeDao.updateSalary(id, salary);		
							case 4: break;		
						}
					}
					
				case 4: System.out.println("id");
						id = sc.nextInt();
						EmployeeDao.deleteEmployee(id);
				case 5: 
					while(true) {
						System.out.println("1.asc order of emp name 2.desc order of sal 3.emp with high sal 4.back");
						choice = sc.nextInt();
						if(choice == 4) break;
						switch(choice) {
							case 1: System.out.println("asc order of emp name");
									empList = EmployeeDao.orderByName();
									display(empList);
									break;
							case 2: System.out.println("desc order of sal");
									empList = EmployeeDao.getEmployeesOrderBySalDesc();
									display(empList);	
									break;
								
							case 3: System.out.println("Employee earning highest salary");
									System.out.println(EmployeeDao.getEmpWithMaxSalary());
									break;
						}
					}
					
						
			}
		}
	}
	public static void display(ArrayList<Employee> empList)throws ClassNotFoundException, SQLException {
		System.out.println("id, name, email, salary");
		
		for(int i=0; i<empList.size(); i++) {
			System.out.println(empList.get(i));
		}	
	}
}
