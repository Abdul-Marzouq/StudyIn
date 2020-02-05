import javax.swing.SwingUtilities;

import launcher.LaunchWindow;
import student.StudentAuthenticationDialog;

public class Studyin {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
		
				LaunchWindow lw = new LaunchWindow();
				lw.setVisible(true);
				/*StudentAuthenticationDialog sad = new StudentAuthenticationDialog(lw);
				sad.setVisible(false);
				sad.addWindowListener(new java.awt.event.WindowAdapter() {
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				        	//lw.disconnect();
				            System.exit(0);
				        }
				});*/
				
			}			
		});
	}

}
