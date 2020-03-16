package faculty;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dataController.FacultyController;
import events.ClickListener;

public class FacultyAuthenticationDialog extends JDialog implements ActionListener{

	private JLabel facultySignUpDescriptionLabel;
	private JButton facultySignUpButton;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton facultySignInButton;
	private JLabel invalidDataLabel;
	private JButton forgotPasswordButton;
	private FacultyAuthenticationSignUpDialog fasupd;
	private FacultyAuthenticationPasswordChangeDialog fapcd;
	private ClickListener clickListener;
	private FacultyController scontroller;

	public FacultyAuthenticationDialog(JFrame parent,FacultyController controller) {

		super(parent, "Faculty Authentication Panel", false);
		scontroller = controller;
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		userNameLabel = new JLabel("Account User Name: ");
		passwordLabel = new JLabel("Account Password: ");
		userNameField = new JTextField(12);
		passwordField = new JPasswordField(12);
		facultySignUpDescriptionLabel = new JLabel("In case of a new account,  ");
		facultySignUpButton = new JButton("Sign Up");
		facultySignInButton = new JButton("Sign In");
		invalidDataLabel = new JLabel(" ");
		forgotPasswordButton = new JButton("Forgot Password?");
		
		facultySignUpButton.addActionListener(this);
		facultySignInButton.addActionListener(this);
		forgotPasswordButton.addActionListener(this);

		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(20,0,20,15);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(userNameLabel, gc);	

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(userNameField, gc);	

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(passwordLabel, gc);	

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passwordField, gc);	

		gc.insets = new Insets(20,0,20,0);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(invalidDataLabel, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		add(facultySignInButton, gc);	

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		add(forgotPasswordButton, gc);	

		gc.insets = new Insets(30,0,30,0);
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(facultySignUpDescriptionLabel, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.SOUTHWEST;
		add(facultySignUpButton, gc);
		setSize(500,370);
	}
	
	public void actionPerformed(ActionEvent e) {

		JButton clicked = (JButton)e.getSource();
		if(clicked == forgotPasswordButton) {
			fapcd = new FacultyAuthenticationPasswordChangeDialog(this,scontroller);
		}
		else if(clicked == facultySignUpButton) {
			fasupd = new FacultyAuthenticationSignUpDialog(this,scontroller);
		}
		else if(clicked == facultySignInButton) {
			int id = scontroller.signincheck(userNameField.getText(),passwordField.getPassword());
			clickListener.clickedNum(id);
			
		}
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
}
