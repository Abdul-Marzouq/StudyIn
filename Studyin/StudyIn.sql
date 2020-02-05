drop table Student;

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

insert into Student values (1000,"Abdul Marzouq",21,"majjucool","Majjucha",2,"IISD",2547,"y");
insert into Student values (1001,"a",21,NULL,NULL,2,NULL,2548,"n");
