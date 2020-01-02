package admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dataModel.Student;

public class AdminStudentShowTableModel extends AbstractTableModel {
	
	private List<Student> db;
	private String[] colnames = {"Student_ID", "Name", "Age"};
	
	public AdminStudentShowTableModel() {
		
	}
	
	public void setData(List<Student> db) {
		this.db = db;
	}
	
	public String getColumnName(int column) {
		return colnames[column];
	}

	public int getRowCount() {
		return db.size();
	}


	public int getColumnCount() {
		return 3;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = db.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return student.getStudentId();
		case 1:
			return student.getStudentName();
		case 2:
			return student.getStudentAge();

		}
		return null;
		
	}

}
