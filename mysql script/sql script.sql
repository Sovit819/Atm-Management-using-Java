create database bankmanagementsystem;
show databases;

create table signup (Application_no varchar(20), Name varchar(20),  Date_of_Birth varchar(15), Father_Name varchar(25), Gender varchar(10),Phone varchar(10), Email varchar(30), Marital_Status varchar(15), Address varchar(30), City varchar(20), Country varchar(20), Pincode varchar(6));
select * from signup;

create table signuptwo (Application_no varchar(20), Religion varchar(10), Income varchar(20), Education varchar(15), Occupation varchar(20), Citizenship_Number varchar(15), Pan_Number varchar(10), Senior_Citizen varchar(5), Existing_Account varchar(5));
select * from signuptwo;

create table signupthree (Application_no varchar(20), Account_type varchar(20), Card_Number varchar(16), Pin_Number varchar(4), Services varchar(100));
select * from signupthree;

create table login (Card_Number varchar(16), Pin_Number varchar(4) );
select * from login;

create table transaction (card_number varchar(16), pin_number varchar(4), date varchar(30), Type_of_Transaction varchar(15), amount varchar(10), Total_Balance varchar(15));
select * from transaction;

SET SQL_SAFE_UPDATES = 0;

delete from signup;
delete from signuptwo;
delete from signupthree;
