package student;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import dataController.StudentController;
import events.ClickListener;

public class StudentAuthenticationPasswordChangeDialog extends JDialog{
	
	private StudentAuthenticationPasswordChangeAccountConfirmPanel sapcacp;
	
	public StudentAuthenticationPasswordChangeDialog(JDialog parent,StudentController controller) {
		
		super(parent,"Change Password",false);
		setVisible(true);
		setLayout(new BorderLayout());
		
		sapcacp = new StudentAuthenticationPasswordChangeAccountConfirmPanel(controller);
		add(sapcacp, BorderLayout.CENTER);
		sapcacp.setVisible(true);

		sapcacp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus == -1)
					setVisible(false);
			}
		});
		
		
			
		setSize(600,480);
	}

}
