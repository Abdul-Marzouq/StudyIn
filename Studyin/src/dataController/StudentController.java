package dataController;

import java.sql.SQLException;
import java.util.List;

import dataModel.Student;
import dataModel.StudentDatabase;
import events.FormEvent;

public class StudentController {
	
	private StudentDatabase db;
	
	public StudentController(){
		db = new StudentDatabase();
	}
	
	public StudentController(boolean load){
		db = new StudentDatabase();
		try {
			db.load();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStudent(FormEvent e) {
		
		String name = e.getName();
		String age = e.getAge();
		
		Student student = new Student(db.get_lastID()+1, name, age, "");
		
		try {
			db.addStudent(student);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public boolean signupconfirm(int id, String name,int cnf) {
		return db.cnfNoCheck(id, name, cnf);
	}

	
	public boolean setpassword(int id,String uName,char[] pwd,int sqno,String ans) {
		try {
			String passwd = new String(pwd);
			Student st = db.getStudentbyID(id);
			System.out.println(passwd);
			if(st.isAccount_Status() == true)
				return db.updatePassword(id,uName,passwd,sqno,ans);
			else
				return db.updateStudentSecurityInfo(id,uName,passwd,sqno,ans);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Student> getStudentDatabase() {
		return db.getStudentList();
	}
	
	public boolean isID(int id) {
		return db.isID(id);
	}
	
	public Student getStudentbyID(int id) {
		return db.getStudentbyID(id);
	}
	
	public void updateStudentbyID(int id, String name, String age) {
		try {
			db.updateStudentbyID(id,name,age);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentbyID(int id) {
		db.deleteStudentbyID(id);
	}
	
	public void disconnectDatabase() {
		db.disconnect();
	}
}
