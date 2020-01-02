package student;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class StudentAuthenticationSignUpDialog extends JDialog{
	
	private StudentAuthenticationSignUpAccountConfirmPanel sasuacp;
	private StudentAuthenticationSignUpAccountInfoPanel sasuaip;
	
	public StudentAuthenticationSignUpDialog(JDialog parent) {
		
		super(parent,"Student Create Account", false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		sasuacp = new StudentAuthenticationSignUpAccountConfirmPanel();
		sasuaip = new StudentAuthenticationSignUpAccountInfoPanel();
		add(sasuacp, BorderLayout.CENTER);
		add(sasuaip, BorderLayout.CENTER);
		sasuacp.setVisible(true);
		sasuaip.setVisible(false);
		
		setSize(600,450);
	}

}
