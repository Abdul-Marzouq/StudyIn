package student;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class StudentAuthenticationPasswordChangeDialog extends JDialog{
	
	private StudentAuthenticationPasswordChangeAccountConfirmPanel sapcacp;
	
	public StudentAuthenticationPasswordChangeDialog(JDialog parent) {
		
		super(parent,"Change Password",false);
		setVisible(true);
		
		sapcacp = new StudentAuthenticationPasswordChangeAccountConfirmPanel();
		
		setLayout(new BorderLayout());
		add(sapcacp, BorderLayout.CENTER);
		
		setSize(625,450);
	}

}
