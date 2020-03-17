package admin;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import dataController.FacultyController;
import dataController.StudentController;
import events.ClickListener;

public class AdminWindow extends JFrame {
	
	private AdminButtonPanel amwbp;
	private JTabbedPane tabpane;
	private AdminStudentsShowTablePanel asstp;
	private AdminFacultyShowTablePanel fsstp;
	private AdminStudentCreateUpdateDialog ascd;
	private AdminStudentCreateUpdateDialog asud;
	private AdminFacultyCreateUpdateDialog fscd;
	private AdminFacultyCreateUpdateDialog fsud;
	private ClickListener listener;
	
	private int id;
	
	StudentController studentController;
	FacultyController facultyController;
	
	public AdminWindow(){
		
		super("StudyIn - Admin");
		
		setLayout(new BorderLayout());
		studentController = new StudentController(true);
		facultyController = new FacultyController(true);
		
		id = -1;
		
		amwbp = new AdminButtonPanel();
		
		ascd = new AdminStudentCreateUpdateDialog(this,"Create Student Account",studentController);
		ascd.setVisible(false);
		asud = new AdminStudentCreateUpdateDialog(this,"Update Student Account",studentController);
		asud.setVisible(false);
		asstp = new AdminStudentsShowTablePanel();
		asstp.setData(studentController.getStudentDatabase());
		
		fscd = new AdminFacultyCreateUpdateDialog(this,"Create Faculty Account",facultyController);
		fscd.setVisible(false);
		fsud = new AdminFacultyCreateUpdateDialog(this,"Update Faculty Account",facultyController);
		fsud.setVisible(false);
		fsstp = new AdminFacultyShowTablePanel();
		fsstp.setData(facultyController.getFacultyDatabase());
		
		tabpane = new JTabbedPane();
		tabpane.add("Student",asstp);
		tabpane.add("Faculty",fsstp);
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(3,3,3,3);
		tabpane.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		add(amwbp, BorderLayout.NORTH);
		add(tabpane, BorderLayout.CENTER);
		
		amwbp.setClicklistener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 1) {
					if(tabpane.getSelectedIndex() == 0)
						ascd.setVisible(true);
					else
						fscd.setVisible(true);
				}
				if(ClickStatus == 2 && id != -1) {
					if(tabpane.getSelectedIndex() == 0) {
						asud.setID(id);
						asud.setupdateinfo();
						System.out.println(id);
						asud.setVisible(true);
					}
					else {
						fsud.setID(id);
						fsud.setupdateinfo();
						System.out.println(id);
						fsud.setVisible(true);
					}
				}
				if(ClickStatus == 3 && id != -1)
				{
					if(tabpane.getSelectedIndex() == 0) {
						studentController.deleteStudentbyID(id);
						reset();
					}
					else {
						facultyController.deleteFacultybyID(id);
						reset();
					}
				}
			}	
		});
		
		asstp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				id = ClickStatus;
			}	
		});
		
		ascd.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		asud.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});
		
		fsstp.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				id = ClickStatus;
			}	
		});
		
		fscd.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});

		fsud.setClickListener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				if(ClickStatus == 100) {
					reset();
				}
			}
		});
		
		setSize(750,500);
	 	setVisible(true);
	}

	public void reset() {
		ascd.resetTextField();
		asud.resetTextField();
		asstp.refresh();
		ascd.setVisible(false);
		asud.setVisible(false);
		
		fscd.resetTextField();
		fsud.resetTextField();
		fsstp.refresh();
		fscd.setVisible(false);
		fsud.setVisible(false);
	}
	
	public void disconnect() {
		studentController.disconnectDatabase();
		facultyController.disconnectDatabase();
	}
	
}
