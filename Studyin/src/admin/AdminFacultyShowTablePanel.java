package admin;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataModel.Faculty;
import events.ClickListener;

public class AdminFacultyShowTablePanel extends JPanel {
	
	private JTable tableFacultys;
	private AdminFacultyShowTableModel tableModel;
	private ClickListener clickListener;
	private String[] colnames = {"Faculty_ID", "Name", "Age"};
	
	public AdminFacultyShowTablePanel() {
		 
		tableModel = new AdminFacultyShowTableModel();
		tableFacultys = new JTable(tableModel);		
		
		setLayout(new BorderLayout());
		
		add(tableFacultys, BorderLayout.CENTER);
		add(new JScrollPane(tableFacultys), BorderLayout.CENTER);
		
	}
	
	public void setData(List<Faculty> list) {
		tableModel.setData(list);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
		
	}
}
