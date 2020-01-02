package admin;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import dataController.FacultyController;
import dataController.StudentController;
import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminWorkingPanel extends JPanel {
		
	private AdminStudentCreateFormPanel amwfp;
	private AdminStudentsShowTablePanel asstp;
	private AdminStudentUpdatePanel ausp;
	private AdminStudentDeletePanel adsp;
	private AdminFacultyCreateFormPanel fmwfp;
	private AdminFacultyShowTablePanel fsstp;
	private AdminFacultyUpdatePanel fusp;
	private AdminFacultyDeletePanel fdsp;
	
	StudentController studentController;
	FacultyController facultyController;
	
	public AdminWorkingPanel(StudentController s, FacultyController f){
		
		setLayout(new BorderLayout());
		
		Dimension dim = getPreferredSize();
		dim.width = 850;
		setMinimumSize(dim);
		
		studentController = s;
		amwfp = new AdminStudentCreateFormPanel();
		asstp = new AdminStudentsShowTablePanel();
		ausp = new AdminStudentUpdatePanel(studentController);
		adsp = new AdminStudentDeletePanel(studentController);
		
		facultyController = f;
		fmwfp = new AdminFacultyCreateFormPanel();
		fsstp = new AdminFacultyShowTablePanel();
		fusp = new AdminFacultyUpdatePanel(facultyController);
		fdsp = new AdminFacultyDeletePanel(facultyController);
		
		asstp.setData(studentController.getStudentDatabase());	
		ausp.setStudentController(studentController);
		adsp.setStudentController(studentController);
		
		fsstp.setData(facultyController.getFacultyDatabase());	
		fusp.setFacultyController(facultyController);
		fdsp.setFacultyController(facultyController);
		
		amwfp.setFormListener(new FormListener() {
			public void FormEventOccurred(FormEvent e) {
				studentController.addStudent(e);
				asstp.refresh();
			}
		});
	
		fmwfp.setFormListener(new FormListener() {
			public void FormEventOccurred(FormEvent e) {
				facultyController.addFaculty(e);
				fsstp.refresh();
			}
		});
		
		amwfp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		ausp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		adsp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		fmwfp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		fusp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		fdsp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});
		
	 	setVisible(true);
	}

	public void display(int clickStatus) {
		reset();
		switch(clickStatus) {
			case 1: {
				add(amwfp, BorderLayout.CENTER);
				amwfp.setVisible(true);
				amwfp.resetTextField();
				break;
			}
			case 2: {
				add(ausp, BorderLayout.CENTER);
				ausp.setVisible(true);
				ausp.clearTextField();
				break;
			}
			case 3: {
				add(adsp, BorderLayout.CENTER);
				adsp.setVisible(true);
				adsp.clearTextField();
				break;
			}
			case 4: {
				add(asstp, BorderLayout.CENTER);
				asstp.setVisible(true);
				break;
			}
			case 5: {
				add(fmwfp, BorderLayout.CENTER);
				fmwfp.setVisible(true);
				fmwfp.resetTextField();
				break;
			}
			case 6: {
				add(fusp, BorderLayout.CENTER);
				fusp.setVisible(true);
				fusp.clearTextField();
				break;
			}
			case 7: {
				add(fdsp, BorderLayout.CENTER);
				fdsp.setVisible(true);
				fdsp.clearTextField();
				break;
			}
			case 8: {
				add(fsstp, BorderLayout.CENTER);
				fsstp.setVisible(true);
				break;
			}
		}
	}
	
	public void reset() {
		amwfp.resetTextField();
		ausp.clearTextField();
		adsp.clearTextField();
		fmwfp.resetTextField();
		fusp.clearTextField();
		fdsp.clearTextField();
		
		amwfp.setVisible(false);
		ausp.setVisible(false);
		adsp.setVisible(false);
		asstp.setVisible(false);
		fmwfp.setVisible(false);
		fusp.setVisible(false);
		fdsp.setVisible(false);
		fsstp.setVisible(false);
	}
}
