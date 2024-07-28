create database amnetdigitaldb;
use amnetdigitaldb;
create table ademployees(eid int primary key, ename varchar(25) not null, email varchar(50) unique not null, salary decimal(15,2)); 
desc ademployees;
select * from ademployees;
truncate table ademployees;

delimiter //
create procedure getEmployeesOrderByName()
begin
	select * from ademployees
    order by ename;
end//
drop procedure getEmployeesOrderBySalDesc;
delimiter //
create procedure getEmployeesOrderBySalDesc()
begin
	select * from ademployees
    order by salary desc;
end//

delimiter //
create procedure getEmployeeWithHighestSal()
begin 
	select ename from ademployees
    order by salary desc
    limit 1;
end//

