package student;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import dataController.StudentController;
import events.ClickListener;

public class StudentAuthenticationSignUpDialog extends JDialog{
	
	private StudentAuthenticationSignUpAccountConfirmPanel sasuacp;
	private StudentAuthenticationSignUpAccountInfoPanel sasuaip;
	
	public StudentAuthenticationSignUpDialog(JDialog parent,StudentController controller) {
		
		super(parent,"Student Create Account", false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		sasuacp = new StudentAuthenticationSignUpAccountConfirmPanel(controller);
		add(sasuacp, BorderLayout.CENTER);
		sasuacp.setVisible(true);
		sasuaip = new StudentAuthenticationSignUpAccountInfoPanel(controller);
		sasuaip.setVisible(false);
		sasuacp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 0) {
					add(sasuaip, BorderLayout.CENTER);
					sasuaip.setid(clickStatus);
					sasuacp.setVisible(false);
					sasuaip.setVisible(true);
				}		
			}
		});
		sasuaip.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus == -1) {
					sasuacp.setVisible(false);
					sasuaip.setVisible(false);
					setVisible(false);
				}		
			}
		});
			
		setSize(600,450);
	}

}
