package faculty;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import dataController.FacultyController;
import events.ClickListener;

public class FacultyAuthenticationSignUpDialog extends JDialog{
	
	private FacultyAuthenticationSignUpAccountConfirmPanel fasuacp;
	private FacultyAuthenticationSignUpAccountInfoPanel fasuaip;
	
	public FacultyAuthenticationSignUpDialog(JDialog parent,FacultyController controller) {
		
		super(parent,"Faculty Create Account", false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		fasuacp = new FacultyAuthenticationSignUpAccountConfirmPanel(controller);
		add(fasuacp, BorderLayout.CENTER);
		fasuacp.setVisible(true);
		fasuaip = new FacultyAuthenticationSignUpAccountInfoPanel(controller);
		fasuaip.setVisible(false);
		fasuacp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 0) {
					add(fasuaip, BorderLayout.CENTER);
					fasuaip.setid(clickStatus);
					fasuacp.setVisible(false);
					fasuaip.setVisible(true);
				}		
			}
		});
		fasuaip.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus == -1) {
					fasuacp.setVisible(false);
					fasuaip.setVisible(false);
					setVisible(false);
				}		
			}
		});
			
		setSize(600,450);
	}

}
