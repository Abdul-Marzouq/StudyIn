package admin;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataModel.Student;
import events.ClickListener;

public class AdminStudentsShowTablePanel extends JPanel {
	
	private JTable tableStudents;
	private AdminStudentShowTableModel tableModel;
	private ClickListener clickListener;
	
	public AdminStudentsShowTablePanel() {
		 
		tableModel = new AdminStudentShowTableModel();
		tableStudents = new JTable(tableModel);
		setLayout(new BorderLayout());
		
		tableStudents.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = tableStudents.rowAtPoint(e.getPoint());
				clickListener.clickedNum(Integer.parseInt(
						tableStudents.getValueAt(row, 0).toString()));
				//System.out.print();
				
			}
		});
		
		add(tableStudents, BorderLayout.CENTER);
		add(new JScrollPane(tableStudents), BorderLayout.CENTER);
		

	}
	
	public void setData(List<Student> db) {
		tableModel.setData(db);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
		
	}
}
