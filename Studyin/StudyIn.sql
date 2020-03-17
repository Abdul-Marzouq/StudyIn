drop table Doubt;
drop table Student;
drop table Faculty;

create table Student (
Student_ID int(4) NOT NULL,
Name varchar(30) NOT NULL,
Age int(2) default NULL,
Username varchar(20) default NULL,
Password varchar(30) default NULL,
SQ_No int(1) default NULL,
SQ_Answer varchar(25) default NULL,
CNF_No int(4) default NULL,
Account_Status char(1) default 'n',
PRIMARY KEY (Student_ID));

insert into Student values (1000,"Abdul Marzouq",21,"majjucool","Majjucha"
,2,"IISD",2547,"y");
insert into Student values (1001,"a",21,NULL,NULL,2,NULL,2548,"n");

create table Faculty (
Faculty_ID int(4) NOT NULL,
Name varchar(30) NOT NULL,
Age int(2) default NULL,
Username varchar(20) default NULL,
Password varchar(30) default NULL,
SQ_No int(1) default NULL,
SQ_Answer varchar(25) default NULL,
CNF_No int(4) default NULL,
Account_Status char(1) default 'n',
Subject varchar(15) default NULL,
PRIMARY KEY (Faculty_ID));

insert into Faculty values (1000,"Ram Krishna",54,"ramk","ramboy",2,"IISD",2547,"y","Physics");

create table Doubt (
Doubt_ID int(5) NOT NULL,
Student_ID int(4) NOT NULL,
Subject varchar(15) DEFAULT NULL,
Question varchar(200) DEFAULT NULL,
Answer varchar(500) DEFAULT NULL,
Faculty_ID int(4) NOT NULL,
PRIMARY KEY (Doubt_ID),
CONSTRAINT Asked_By FOREIGN KEY (Student_ID) REFERENCES Student (Student_ID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT Answered_By FOREIGN KEY (Faculty_ID) REFERENCES Faculty (Faculty_ID) ON DELETE CASCADE ON UPDATE CASCADE
);
