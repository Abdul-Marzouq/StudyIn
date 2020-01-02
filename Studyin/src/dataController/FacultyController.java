package dataController;

import java.sql.SQLException;
import java.util.List;

import dataModel.Faculty;
import dataModel.FacultyDatabase;
import events.FormEvent;

public class FacultyController {
	
	private FacultyDatabase db;
	private int last_ID;
	
	public FacultyController(){
		db = new FacultyDatabase();
	}
	
	public FacultyController(boolean load){
		db = new FacultyDatabase();
		try {
			db.load();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addFaculty(FormEvent e) {
		
		String name = e.getName();
		String age = e.getAge();
		
		Faculty faculty = new Faculty(db.get_lastID()+1, name, age);
		
		db.addFaculty(faculty);
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
	
	public void updateFacultybyID(int id, String name, String age) {
		db.updateFacultybyID(id,name,age);
	}
	
	public void deleteFacultybyID(int id) {
		db.deleteFacultybyID(id);
	}
	
	public void disconnectDatabase() {
		db.disconnect();
	}
}
