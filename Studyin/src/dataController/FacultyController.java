package dataController;

import java.sql.SQLException;
import java.util.List;

import dataModel.Faculty;
import dataModel.FacultyDatabase;
import events.FormEvent;

public class FacultyController {
	
	private FacultyDatabase db;
	
	public FacultyController(){
		db = new FacultyDatabase();
	}
	
	public FacultyController(boolean load){
		db = new FacultyDatabase();
		try {
			db.load();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFaculty(FormEvent e) {
		
		String name = e.getName();
		String age = e.getAge();
		String sub = e.getSubject();
		
		Faculty faculty = new Faculty(db.get_lastID()+1, name, age, sub);
		
		try {
			db.addFaculty(faculty);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean signupconfirm(int id, String name,int cnf) {
		return db.cnfNoCheck(id, name, cnf);
	}

	
	public boolean setpassword(int id,String uName,char[] pwd,String sqstn,String ans) {
		try {
			String passwd = new String(pwd);
			Faculty st = db.getFacultybyID(id);
			if(st.isAccount_Status() == true)
				return db.updatePassword(id,uName,passwd,retsqno(sqstn),ans);
			else
				return db.updateFacultySecurityInfo(id,uName,passwd,retsqno(sqstn),ans);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int signincheck(String uname,char[] pwd) {
		Faculty st = db.getFacultybyuname(uname);
		if(st != null) {
			if(st.checkPassword(new String(pwd)))
				return st.getFacultyId();
			else return -1;
		}
		else
			return -1;
	}
	
	public boolean checkSecInfo(int id,String uname,int qno,String ans) {
		Faculty st = db.getFacultybyID(id);
		if(st.getFacultyUsername().equals(uname) && 
				st.getSQ_No() == qno && st.getSQ_Answer().equals(ans)
				&& st.isAccount_Status())
			return true;
		else
			return false;
	}
	
	public int retsqno(String sqstn) {
		switch(sqstn) {
		case "What is the name of your first teacher?": return 1;
		case "What was your first pet?": return 2;
		case "Who is your best friend?": return 3;
		}
		return 1;
	}
	
	public List<Faculty> getFacultyDatabase() {
		return db.getFacultyList();
	}
	
	public boolean isID(int id) {
		return db.isID(id);
	}
	
	public Faculty getFacultybyID(int id) {
		return db.getFacultybyID(id);
	}
	
	public void updateFacultybyID(int id, String name, String age,String sub) {
		try {
			db.updateFacultybyID(id,name,age,sub);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFacultybyID(int id) {
		db.deleteFacultybyID(id);
	}
	
	public void disconnectDatabase() {
		db.disconnect();
	}
}
