create database company default character set utf8 default collate utf8_general_ci ;
use company;

create table department (

    deptno  int primary key ,
    deptname varchar(150) UNIQUE,
    location varchar(100)
);

create table project(
    projectno int primary key ,
    projectname varchar(150),
    location varchar(100),
    deptno int,
    foreign key(deptno) references department(deptno)
);

create table employee(
    empno int primary key,
    empname varchar(120) UNIQUE,
    adderss varchar(200),
    sallary double,
    hiringdate date,
    deptno int,
    foreign key(deptno) references department(deptno)
);

create table employee_phone(
    empno int,
    phone varchar(55),
    primary KEY(empno,phone),
    foreign key(empno) references employee(empno) 
);

create table workon(
    empno int,
    projectno int,
    primary key(empno,projectno),
    foreign key(empno) references employee(empno),
    foreign key(projectno) references project(projectno)
);





create view employee_data
as select empno as 'nember',
empname as 'name',
sallary ,
adderss,
hiringdate as 'hiring_date',
birthdate as 'birth_of_date',
department.deptno,
deptname as 'department'
from employee , department
where employee.deptno = department.deptno



create view department_data
as select 
deptno as 'department_no',
deptname as 'department'
from department




create view employee_phone_data
 as select
 employee.empno as 'employee_no',
 empname as 'name',
 phone from employee,employee_phone 
where employee_phone.empno = employee.empno


create view project_data 
as select 
projectno as 'project_number',
projectname as 'neme',
project.location,
project.deptno as 'department_no',
deptname as 'department'
from project,department
where project.deptno=department.deptno


create view work_on_data
as select workon.empno as 'Employee_no',
empname as 'employee_name',
workon.projectno as 'project_no',
projectname as 'project_name'
from project,employee,workon
where workon.empno = employee.empno
and project.projectno = workon.projectno