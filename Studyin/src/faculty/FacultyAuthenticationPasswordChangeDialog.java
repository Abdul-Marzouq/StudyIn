package faculty;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import dataController.FacultyController;
import events.ClickListener;

public class FacultyAuthenticationPasswordChangeDialog extends JDialog{
	
	private FacultyAuthenticationPasswordChangeAccountConfirmPanel fapcacp;
	
	public FacultyAuthenticationPasswordChangeDialog(JDialog parent,FacultyController controller) {
		
		super(parent,"Change Password",false);
		setVisible(true);
		setLayout(new BorderLayout());
		
		fapcacp = new FacultyAuthenticationPasswordChangeAccountConfirmPanel(controller);
		add(fapcacp, BorderLayout.CENTER);
		fapcacp.setVisible(true);

		fapcacp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus == -1)
					setVisible(false);
			}
		});
		
		
			
		setSize(600,480);
	}

}
