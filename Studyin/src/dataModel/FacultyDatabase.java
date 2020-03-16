package dataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyDatabase {
	
	private ArrayList<Faculty> FacultyList; 
	private Connection con;
	
	public FacultyDatabase() {
		FacultyList = new ArrayList<Faculty>();
	}

	public void addFaculty(Faculty newFaculty) throws SQLException {
		FacultyList.add(newFaculty);
		insert(newFaculty);

	}
	
	public List<Faculty> getFacultyList() {
		return FacultyList;
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
		
		FacultyList.clear();
		String checksql = "select Faculty_ID, Name, Age, Username, Password, SQ_No, SQ_Answer, CNF_No, Account_Status from Faculty order by Faculty_ID";
		connect();
		if(con != null) {
			Statement selstmt = con.createStatement();
		
			ResultSet result = selstmt.executeQuery(checksql);
		
			while(result.next()) {
				int id = result.getInt("Faculty_ID");
				String name = result.getString("Name");
				String age = result.getString("Age");
				String username = result.getString("Username");
				String password = result.getString("Password");
				int sqno = result.getInt("SQ_No");
				String sqans = result.getString("SQ_Answer");
				int cnfno = result.getInt("CNF_No");
				String stat = result.getString("Account_Status");
				boolean st;
				if(stat.equals("y"))
					st = true;
				else
					st = false;
				Faculty faculty = new Faculty(id,name,age,username,password,sqno,sqans,cnfno,st);
				FacultyList.add(faculty);
			}
			selstmt.close();
		}
	}		
	
	public void insert(Faculty newFaculty) throws SQLException {
		String insertsql = "insert into Faculty values(?, ?, ?, ?, ?, ?)";
		PreparedStatement insstmt = con.prepareStatement(insertsql);
		int col = 1;
		insstmt.setInt(col++, newFaculty.getFacultyId());
		insstmt.setString(col++, newFaculty.getFacultyName());
		insstmt.setString(col++, newFaculty.getFacultyAge());
		insstmt.setString(col++, newFaculty.getFacultyUsername());
		insstmt.setString(col++, newFaculty.getFacultyName() + newFaculty.getFacultyAge());
		insstmt.setInt(col++, newFaculty.getCnfno());
		insstmt.executeUpdate();
		insstmt.close();
	}
	
	public void update(int id, String name, String age) throws SQLException {
		
		String updatesql = "update Faculty set Name = ?, Age = ? where Faculty_ID = ?";
		PreparedStatement updstmt = con.prepareStatement(updatesql);
		int col = 1;
		updstmt.setString(col++, name);
		updstmt.setString(col++, age);
		updstmt.setInt(col++, id);
		updstmt.executeUpdate();
		updstmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String deletesql = "delete from Faculty where Faculty_ID = ?";
		PreparedStatement delstmt = con.prepareStatement(deletesql);
		delstmt.setInt(1, id);
		delstmt.executeUpdate();
		delstmt.close();
	}
	
	public boolean isID(int id) {
		for(int i=0;i<FacultyList.size();i++) {
			if(id == FacultyList.get(i).getFacultyId())
				return true;
		}
		return false;
	}
	
	public Faculty getFacultybyID(int id) {
		for(int i=0;i<FacultyList.size();i++) {
			if(id == FacultyList.get(i).getFacultyId())
				return FacultyList.get(i);
		}
		return null;
	}
	
	public Faculty getFacultybyuname(String uname) {
		for(int i=0;i<FacultyList.size();i++) {
			if(uname.equals(FacultyList.get(i).getFacultyUsername()))
				return FacultyList.get(i);
		}
		return null;
	}
	
	public boolean updateFacultySecurityInfo(int sq_id, String uName,String pwd,int sq_no,String sq_ans) throws SQLException {
		String updatesql = "update Faculty set Username = ?,Password = ?,SQ_No = ?, SQ_Answer = ?, Account_Status = ? where Faculty_ID = ?";
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
	
	public void updateFacultybyID(int id, String name, String age) throws SQLException {
		Faculty faculty = getFacultybyID(id);
		faculty.setFacultyName(name);
		faculty.setFacultyAge(age);
		update(id,name,age);
	}
	
	public void deleteFacultybyID(int id) {
		Faculty faculty = getFacultybyID(id);
		try {
			delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		FacultyList.remove(faculty);
	}
	
	public int get_lastID() {
		if(FacultyList.size() == 0)
			return 0;
		else
			return FacultyList.get(FacultyList.size()-1).getFacultyId();
	}
	
	public boolean cnfNoCheck(int id,String name,int cnfNo) {
		Faculty temp = getFacultybyID(id);
		if(temp.getFacultyName().equals(name) && temp.getCnfno() == cnfNo)
			return true;
		else
			return false;
	}
	
	public boolean updatePassword(int id,String uName,String pwd,int sqno,String ans) throws SQLException {
		Faculty temp = getFacultybyID(id);
		if(temp.getFacultyUsername().equals(uName) && temp.getSQ_No() == sqno && temp.getSQ_Answer().equals(ans)) {
			temp.setPassword(pwd);
			String updatesql = "update Faculty set Password = ? where Faculty_ID = ?";
			PreparedStatement updstmt = con.prepareStatement(updatesql);
			updstmt.setString(1, pwd);
			updstmt.setInt(2, temp.getFacultyId());
			updstmt.executeUpdate();
			updstmt.close();
			return true;
		}
		else
			return false;
	}
}
