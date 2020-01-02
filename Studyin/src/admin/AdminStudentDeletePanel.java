package admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import dataController.StudentController;
import dataModel.Student;
import events.ClickListener;

public class AdminStudentDeletePanel extends JPanel{
	
	private AdminStudentDeleteInfoPanel adsip;
	private AdminStudentDeleteIDCheckPanel adsicp;
	private JButton backButton;
	private StudentController studentController;
	private Student student;
	private ClickListener clickListener;
	
	public AdminStudentDeletePanel(StudentController s) {
		
		adsicp = new AdminStudentDeleteIDCheckPanel(s);
		adsip = new AdminStudentDeleteInfoPanel();
		studentController = s;
		
		setLayout(new BorderLayout());
		
		add(adsicp, BorderLayout.CENTER);
		
		adsicp.setStudentController(studentController);
		
		adsicp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 0) {
					student = studentController.getStudentbyID(clickStatus);
					adsip.setStudent(student);
					add(adsip, BorderLayout.CENTER);
					adsicp.setVisible(false);
					adsip.setVisible(true);
				}
				else {
					add(adsicp, BorderLayout.CENTER);
					adsicp.setVisible(true);
					adsip.setVisible(false);
				}
			}
		});
		
		adsip.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				studentController.deleteStudentbyID(student.getStudentId());
				clickListener.clickedNum(100);
				add(adsicp, BorderLayout.CENTER);
				adsicp.setVisible(true);
				adsip.setVisible(false);
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
		adsicp.resetTextField();
	}
}
