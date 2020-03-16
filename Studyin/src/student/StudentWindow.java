package student;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import dataController.StudentController;
import events.ClickListener;

public class StudentWindow extends JFrame{
		
		private StudentAuthenticationDialog sad;
	//	private StudentWorkingPanel swp;
		private JSplitPane splitPane;
		private ClickListener listener;
		
		StudentController studentController;

		public StudentWindow() {
			super("StudyIn - Student");
			System.out.println("Hello");
			
			setLayout(new BorderLayout());
			studentController = new StudentController(true);
			setVisible(false);
			
			sad = new StudentAuthenticationDialog(this,studentController);
			sad.setVisible(true);
			sad.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        	disconnect();
			            System.exit(0);
			        }
			});
			
			sad.setClickListener( new ClickListener() {
				public void clickedNum(int clickStatus) {
					if(clickStatus != -1) {
						sad.setVisible(false);
						setVisible(true);
					}
				}
			});
			
			/*sbp = new StudentButtonPanel();
			swp = new StudentWorkingPanel(studentController);*/
			
			/*add(sap, BorderLayout.CENTER);
			/*splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sbp, swp);
			add(splitPane, BorderLayout.CENTER)
			splitPane.setOneTouchExpandable(true);

			sbp.setClicklistener(new ClickListener() {
				public void clickedNum(int ClickStatus) {
							swp.display(ClickStatus);
				}	
			});
			 */
			setSize(500,480);
		}

		public void disconnect() {
			studentController.disconnectDatabase();
			
		}
}
