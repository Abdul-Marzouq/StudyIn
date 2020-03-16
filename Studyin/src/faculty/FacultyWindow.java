package faculty;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import dataController.FacultyController;
import events.ClickListener;

public class FacultyWindow extends JFrame{
		
		private FacultyAuthenticationDialog fad;
		private JSplitPane splitPane;
		private ClickListener listener;
		
		FacultyController facultyController;

		public FacultyWindow() {
			super("StudyIn - Faculty");
			System.out.println("Hello");
			
			setLayout(new BorderLayout());
			facultyController = new FacultyController(true);
			setVisible(false);
			
			fad = new FacultyAuthenticationDialog(this,facultyController);
			fad.setVisible(true);
			fad.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        	disconnect();
			            System.exit(0);
			        }
			});
			
			fad.setClickListener( new ClickListener() {
				public void clickedNum(int clickStatus) {
					if(clickStatus != -1) {
						fad.setVisible(false);
						setVisible(true);
					}
				}
			});
			
			
			setSize(500,480);
		}

		public void disconnect() {
			facultyController.disconnectDatabase();
			
		}
}
