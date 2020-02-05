package dataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
	
	private ArrayList<Student> StudentList; 
	private Connection con;
	
	public StudentDatabase() {
		StudentList = new ArrayList<Student>();
	}

	public void addStudent(Student newStudent) throws SQLException {
		StudentList.add(newStudent);
		insert(newStudent);

	}
	
	public List<Student> getStudentList() {
		return StudentList;
	}
	
	public void connect() throws Exception {
		if(con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw  new Exception("Driver not found");
			}
			String connectionUrl = "jdbc:mysql://localhost:3306/StudyIn";
				con = DriverManager.getConnection(connectionUrl,"root","majju@b170263cs");
				System.out.println("Connection Successful....." + con);
			}
	}
	
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
				System.out.println("Disconnection Successful....");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load() throws Exception{
		
		StudentList.clear();
		String checksql = "select Student_ID, Name, Age, Username, Password, CNF_No, Account_Status from Student order by Student_ID";
		connect();
		if(con != null) {
			Statement selstmt = con.createStatement();
		
			ResultSet result = selstmt.executeQuery(checksql);
		
			while(result.next()) {
				int id = result.getInt("Student_ID");
				String name = result.getString("Name");
				String age = result.getString("Age");
				String username = result.getString("Username");
				String password = result.getString("Password");
				int cnfno = result.getInt("CNF_No");
				String stat = result.getString("Account_Status");
				boolean st;
				if(stat.equals("y"))
					st = true;
				else
					st = false;
				Student student = new Student(id,name,age,username,password,cnfno,st);
				StudentList.add(student);
			}
			selstmt.close();
		}
	}		
	
	public void insert(Student newStudent) throws SQLException {
		String insertsql = "insert into Student values(?, ?, ?, ?, ?, ?)";
		PreparedStatement insstmt = con.prepareStatement(insertsql);
		int col = 1;
		insstmt.setInt(col++, newStudent.getStudentId());
		insstmt.setString(col++, newStudent.getStudentName());
		insstmt.setString(col++, newStudent.getStudentAge());
		insstmt.setString(col++, newStudent.getStudentUsername());
		insstmt.setString(col++, newStudent.getStudentName() + newStudent.getStudentAge());
		insstmt.setInt(col++, newStudent.getCnfno());
		insstmt.executeUpdate();
		insstmt.close();
	}
	
	public void update(int id, String name, String age) throws SQLException {
		
		String updatesql = "update Student set Name = ?, Age = ? where Student_ID = ?";
		PreparedStatement updstmt = con.prepareStatement(updatesql);
		int col = 1;
		updstmt.setString(col++, name);
		updstmt.setString(col++, age);
		updstmt.setInt(col++, id);
		updstmt.executeUpdate();
		updstmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String deletesql = "delete from Student where Student_ID = ?";
		PreparedStatement delstmt = con.prepareStatement(deletesql);
		delstmt.setInt(1, id);
		delstmt.executeUpdate();
		delstmt.close();
	}
	
	public boolean isID(int id) {
		for(int i=0;i<StudentList.size();i++) {
			if(id == StudentList.get(i).getStudentId())
				return true;
		}
		return false;
	}
	
	public Student getStudentbyID(int id) {
		for(int i=0;i<StudentList.size();i++) {
			if(id == StudentList.get(i).getStudentId())
				return StudentList.get(i);
		}
		return null;
	}
	
	public boolean updateStudentSecurityInfo(int sq_id, String uName,String pwd,int sq_no,String sq_ans) throws SQLException {
		String updatesql = "update Student set Username = ?,Password = ?,SQ_No = ?, SQ_Answer = ?, Account_Status = ? where Student_ID = ?";
		System.out.println("pass");
		PreparedStatement updstmt = con.prepareStatement(updatesql);
		int col = 1;
		updstmt.setString(col++, uName);
		updstmt.setString(col++, pwd);
		updstmt.setInt(col++, sq_no);
		updstmt.setString(col++, sq_ans);
		updstmt.setString(col++, "y");
		updstmt.setInt(col++, sq_id);
		updstmt.executeUpdate();
		updstmt.close();
		return true;
	}
	
	public void updateStudentbyID(int id, String name, String age) throws SQLException {
		Student student = getStudentbyID(id);
		student.setStudentName(name);
		student.setStudentAge(age);
		update(id,name,age);
	}
	
	public void deleteStudentbyID(int id) {
		Student student = getStudentbyID(id);
		try {
			delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		StudentList.remove(student);
	}
	
	public int get_lastID() {
		if(StudentList.size() == 0)
			return 0;
		else
			return StudentList.get(StudentList.size()-1).getStudentId();
	}
	
	public boolean cnfNoCheck(int id,String name,int cnfNo) {
		Student temp = getStudentbyID(id);
		if(temp.getStudentName().equals(name) && temp.getCnfno() == cnfNo)
			return true;
		else
			return false;
	}
	
	public boolean updatePassword(int id,String uName,String pwd,int sqno,String ans) throws SQLException {
		Student temp = getStudentbyID(id);
		if(temp.getStudentUsername().equals(uName) && temp.getSQ_No() == sqno && temp.getSQ_Answer().equals(ans)) {
			temp.setPassword(pwd);
			String updatesql = "update Student set Password = ? where Student_ID = ?";
			PreparedStatement updstmt = con.prepareStatement(updatesql);
			updstmt.setString(1, pwd);
			updstmt.setInt(2, temp.getStudentId());
			updstmt.close();
			return true;
		}
		else
			return false;
	}
}
