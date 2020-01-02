package admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dataModel.Faculty;

public class AdminFacultyShowTableModel extends AbstractTableModel {
	
	private List<Faculty> db;
	private String[] colnames = {"Faculty_ID", "Name", "Age"};
	
	public AdminFacultyShowTableModel() {
		
	}
	
	public void setData(List<Faculty> db) {
		this.db = db;
	}
	
	@Override
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
		Faculty faculty = db.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return faculty.getFacultyId();
		case 1:
			return faculty.getFacultyName();
		case 2:
			return faculty.getFacultyAge();
		}
		return null;
		
	}

}
