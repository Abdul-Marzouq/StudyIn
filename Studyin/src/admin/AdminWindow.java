package admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import dataController.FacultyController;
import dataController.StudentController;
import events.ClickListener;

public class AdminWindow extends JFrame {
	
	private AdminButtonPanel amwbp;
	private AdminWorkingPanel awp;
	private JSplitPane splitPane;
	private ClickListener listener;
	
	StudentController studentController;
	FacultyController facultyController;
	
	public AdminWindow(){
		
		super("StudyIn - Admin");
		
		setLayout(new BorderLayout());
		studentController = new StudentController(true);
		facultyController = new FacultyController(true);
		
		amwbp = new AdminButtonPanel();
		awp = new AdminWorkingPanel(studentController, facultyController);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, amwbp, awp);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setOneTouchExpandable(true);
		
		amwbp.setClicklistener(new ClickListener() {
			public void clickedNum(int ClickStatus) {
				awp.display(ClickStatus);
			}	
		});

		setSize(900,480);
	 	setVisible(true);
	}

	public void disconnect() {
		studentController.disconnectDatabase();
		facultyController.disconnectDatabase();
	}
}
