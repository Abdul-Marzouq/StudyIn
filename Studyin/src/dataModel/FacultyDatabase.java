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

	public void addFaculty(Faculty newFaculty) {
		FacultyList.add(newFaculty);
		try {
			insert(newFaculty);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public void load() throws SQLException{
		
		FacultyList.clear();
		String checksql = "select Faculty_ID, Name, Age from Faculty order by Faculty_ID";
		
		try {
			connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(con != null) {
			Statement selstmt = con.createStatement();
		
			ResultSet result = selstmt.executeQuery(checksql);
		
			while(result.next()) {
				int id = result.getInt("Faculty_ID");
				String name = result.getString("Name");
				String age = result.getString("Age");
			
				Faculty faculty = new Faculty(id,name,age);
				FacultyList.add(faculty);
			}
			selstmt.close();
		}
	}		
	
	public void insert(Faculty newFaculty) throws SQLException {
		String insertsql = "insert into Faculty values(?, ?, ?)";
		PreparedStatement insstmt = con.prepareStatement(insertsql);
		int col = 1;
		insstmt.setInt(col++, newFaculty.getFacultyId());
		insstmt.setString(col++, newFaculty.getFacultyName());
		insstmt.setString(col++, newFaculty.getFacultyAge());
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
		//System.out.println(id);
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
	
	public void updateFacultybyID(int id, String name, String age) {
		Faculty faculty = getFacultybyID(id);
		faculty.setFacultyName(name);
		faculty.setFacultyAge(age);
		try {
			update(id,name,age);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
}
