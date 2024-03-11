 create table Rent_Member(
 id VARCHAR2(10) PRIMARY KEY, 
 password VARCHAR2(20) NOT NULL, 
 name VARCHAR2(10) NOT NULL, 
 address VARCHAR2(20) NOT NULL, 
 phonenum VARCHAR2(20) NOT NULL
 );
 
 create table Rent_Car(
 carNumber VARCHAR2(10) PRIMARY KEY, 
 carName VARCHAR2(20) NOT NULL, 
 carColor VARCHAR2(10) NOT NULL, 
 carSize NUMBER(5) NOT NULL, 
 carMaker VARCHAR2(20) NOT NULL
 );
  
create table Rent_Res(
resNo VARCHAR2(20) PRIMARY KEY, 
carNumber VARCHAR2(10) REFERENCES Rent_Car(carNumber), 
memberId VARCHAR2(10) REFERENCES Rent_Member(id), 
resDate date, 
useBeginDate date, 
returnDate date,
charge number(10)
);
 

create sequence resNoplus start with 1 increment by 1 maxvalue 99999;
create sequence carNoPlus start with 1 increment by 1 maxvalue 99999;