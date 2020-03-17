package dataModel;

import java.util.Random;

public class Faculty {
	
	private static int count = 0;
	private int FacultyId;
	private String FacultyName;
	private int FacultyAge;
	private String FacultyUsername;
	private String FacultyPassword;
	private int SQ_No;
	private String SQ_Answer;
	private boolean Account_Status;
	private int cnfno;
	private String Subject;
	
	
	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public int getCnfno() {
		return cnfno;
	}

	public void setCnfno(int cnfno) {
		this.cnfno = cnfno;
	}

	public boolean isAccount_Status() {
		return Account_Status;
	}

	public void setAccount_Status(boolean account_Status) {
		Account_Status = account_Status;
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

	public Faculty(int id,String name, int age, String sub) {
		Random rand = new Random();
		this.FacultyId = id;
		this.FacultyAge = age;
		this.FacultyName = name;
		this.Subject = sub;
		this.cnfno = rand.nextInt(1000);
	}
	
	public Faculty(int id,String name, int age, String username,String password,int sqno,String sqans,int cnfno,boolean stat, String sub) {
		this.FacultyId = id;
		this.FacultyAge = age;
		this.FacultyName = name;
		this.FacultyUsername = username;
		this.FacultyPassword = password;
		this.SQ_No = sqno;
		this.SQ_Answer = sqans;
		this.cnfno = cnfno;
		this.Account_Status = stat;
		this.Subject = sub;
	}
	
	public Faculty() {
		
	}

	public int getFacultyId() {
		return FacultyId;
	}
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}
	public String getFacultyName() {
		return FacultyName;
	}
	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
	public int getFacultyAge() {
		return FacultyAge;
	}
	public void setFacultyAge(int facultyAge) {
		FacultyAge = facultyAge;
	}
	public String getFacultyUsername() {
		return FacultyUsername;
	}
	public void setFacultyUsername(String username) {
		FacultyUsername = username;
	}
	public void setPassword(String password) {
		FacultyPassword = password;
	}
	public boolean checkPassword(String pwd) {
		return pwd.equals(FacultyPassword);
	}

}
