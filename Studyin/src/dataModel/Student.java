package dataModel;

import java.util.Random;

public class Student {
	
	private static int count = 0;
	private int StudentId;
	private String StudentName;
	private String StudentAge;
	private String StudentUsername;
	private String StudentPassword;
	private int SQ_No;
	private String SQ_Answer;
	private int cnfno;
	
	
	public int getCnfno() {
		return cnfno;
	}

	public void setCnfno(int cnfno) {
		this.cnfno = cnfno;
	}

	public int getSQ_No() {
		return SQ_No;
	}

	public void setSQ_No(int sQ_No) {
		SQ_No = sQ_No;
	}

	public String getSQ_Answer() {
		return SQ_Answer;
	}

	public void setSQ_Answer(String sQ_Answer) {
		SQ_Answer = sQ_Answer;
	}

	public Student(int id,String name, String age, String username) {
		Random rand = new Random();
		this.StudentId = id;
		this.StudentAge = age;
		this.StudentName = name;
		this.StudentUsername = username;
		this.StudentPassword = name + age;
		this.cnfno = rand.nextInt(1000);
	}
	
	public Student(int id,String name, String age, String username,String password) {
		Random rand = new Random();
		this.StudentId = id;
		this.StudentAge = age;
		this.StudentName = name;
		this.StudentUsername = username;
		this.StudentPassword = password;
	}
	
	public Student() {
		
	}

	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(String studentAge) {
		StudentAge = studentAge;
	}
	public String getStudentUsername() {
		return StudentUsername;
	}
	public void setStudentUsername(String username) {
		StudentUsername = username;
	}
	public void setPassword(String password) {
		StudentPassword = password;
	}

}
