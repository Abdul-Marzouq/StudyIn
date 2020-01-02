package launcher;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import admin.AdminWindow;
import events.ClickListener;
import faculty.FacultyWindow;
import student.StudentAuthenticationDialog;
import student.StudentWindow;


public class LaunchWindow extends JFrame{
	
	private LaunchButtonPanel lbp;
	private AdminWindow aw;
	private FacultyWindow fw;
	private StudentWindow sw;
	
	public LaunchWindow(){
		super("StudyIn");
		setLayout(new BorderLayout());
		
		lbp = new LaunchButtonPanel();
		add(lbp, BorderLayout.CENTER);
		
		lbp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				setVisible(false);
				if(clickStatus == 1) {
						aw = new AdminWindow();
						aw.addWindowListener(new java.awt.event.WindowAdapter() {
						    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						        int result = JOptionPane.showConfirmDialog(aw, 
							            "Are you sure you want to close this window?", "Close Window?", 
							            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    	if (result == JOptionPane.YES_OPTION){
						        	//System.out.println("Hello Word");
						        	aw.disconnect();
						            System.exit(0);
						        }
						        else if (result == JOptionPane.NO_OPTION)
						            aw.setDefaultCloseOperation(aw.DO_NOTHING_ON_CLOSE);
						    }
						});
				}
				else if(clickStatus == 2) {
					fw = new FacultyWindow();
				}
				else if(clickStatus == 3) {
					sw = new StudentWindow();
					sw.addWindowListener(new java.awt.event.WindowAdapter() {
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					        int result = JOptionPane.showConfirmDialog(sw, 
						            "Are you sure you want to close this window?", "Close Window?", 
						            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    	if (result == JOptionPane.YES_OPTION){
					        	sw.disconnect();
					            System.exit(0);
					        }
					        else if (result == JOptionPane.NO_OPTION)
					            sw.setDefaultCloseOperation(aw.DO_NOTHING_ON_CLOSE);
					    }
					});
				}
			}
		});
		
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
