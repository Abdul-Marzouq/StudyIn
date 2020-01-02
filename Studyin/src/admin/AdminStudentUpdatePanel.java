package admin;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import dataController.StudentController;
import dataModel.Student;
import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminStudentUpdatePanel extends JPanel{
	
	private AdminStudentUpdateFormPanel ausfp;
	private StudentController studentController;
	private AdminStudentUpdateIDCheckPanel ausicp;
	private Student student;
	private ClickListener clickListener; 
	
	public AdminStudentUpdatePanel(StudentController s) {

		ausicp = new AdminStudentUpdateIDCheckPanel(s);
		ausfp = new AdminStudentUpdateFormPanel();
		studentController = s;
	
		setLayout(new BorderLayout());
		
		add(ausicp, BorderLayout.CENTER);
		ausicp.setStudentController(studentController);
		
		ausicp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 1) {
					student = studentController.getStudentbyID(clickStatus);
					ausfp.setStudent(student);
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
				studentController.updateStudentbyID(student.getStudentId(),e.getName(),e.getAge());
				clickListener.clickedNum(100);
				add(ausicp, BorderLayout.CENTER);
				ausicp.setVisible(true);
				ausfp.setVisible(false);
			}		
		});
	}
	
	public void setStudentController(StudentController controller) {
		this.studentController = controller;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void clearTextField() {
		ausicp.resetTextField();
	}
}
