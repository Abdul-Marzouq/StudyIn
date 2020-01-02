package admin;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import dataController.FacultyController;
import dataModel.Faculty;
import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminFacultyUpdatePanel extends JPanel{
	
	private AdminFacultyUpdateFormPanel ausfp;
	private FacultyController facultyController;
	private AdminFacultyUpdateIDCheckPanel ausicp;
	private Faculty faculty;
	private ClickListener clickListener; 
	
	public AdminFacultyUpdatePanel(FacultyController s) {

		ausicp = new AdminFacultyUpdateIDCheckPanel(s);
		ausfp = new AdminFacultyUpdateFormPanel();
		facultyController = s;
	
		setLayout(new BorderLayout());
		
		add(ausicp, BorderLayout.CENTER);
		ausicp.setFacultyController(facultyController);
		
		ausicp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 1) {
					faculty = facultyController.getFacultybyID(clickStatus);
					ausfp.setFaculty(faculty);
					add(ausfp, BorderLayout.CENTER);
					ausicp.setVisible(false);
					ausfp.setVisible(true);
				}
				else {
					add(ausicp, BorderLayout.CENTER);
					ausicp.setVisible(true);
					ausfp.setVisible(false);
				}
			}
		});
		
		ausfp.setFormListener(new FormListener() {
			public void FormEventOccurred(FormEvent e) {
				facultyController.updateFacultybyID(faculty.getFacultyId(),e.getName(),e.getAge());
				clickListener.clickedNum(100);
				add(ausicp, BorderLayout.CENTER);
				ausicp.setVisible(true);
				ausfp.setVisible(false);
			}		
		});
	}
	
	public void setFacultyController(FacultyController controller) {
		this.facultyController = controller;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void clearTextField() {
		ausicp.resetTextField();
	}
}
