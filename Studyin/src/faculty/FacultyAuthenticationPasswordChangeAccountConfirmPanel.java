package faculty;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dataController.FacultyController;
import events.ClickListener;

public class FacultyAuthenticationPasswordChangeAccountConfirmPanel extends JPanel {
	
	private JLabel facultyIDLabel;
	private JTextField facultyIDField;
	private JLabel facultyUsernameLabel;
	private JTextField facultyUsernameField;
	private JLabel facultySecurityQuestionLabel;
	private JComboBox facultySecurityQuestionBox;
	private JLabel facultySecurityAnswerLabel;
	private JTextField facultySecurityAnswerField;
	private JLabel facultyPasswordLabel;
	private JPasswordField facultyPasswordField;
	private JLabel facultyConfirmPasswordLabel;
	private JPasswordField facultyConfirmPasswordField; 
	private JLabel invalidDataLabel;
	private JLabel invalidDataLabel2;
	private JButton nextButton;
	private FacultyController facultyController;
	private ClickListener clickListener;
	
	public FacultyAuthenticationPasswordChangeAccountConfirmPanel(FacultyController controller) {
	
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		facultyIDLabel = new JLabel("Faculty ID: ");
		facultyIDField = new JTextField(5);
		facultyUsernameLabel = new JLabel("Username: ");
		facultyUsernameField = new JTextField(10);
		facultySecurityQuestionLabel = new JLabel("Security Question: ");
		facultySecurityQuestionBox = new JComboBox();
		facultySecurityAnswerLabel = new JLabel("Answer: ");
		facultySecurityAnswerField = new JTextField(10);
		facultyPasswordLabel = new JLabel("New Password: ");
		facultyPasswordField = new JPasswordField(10);
		facultyConfirmPasswordLabel = new JLabel("Confirm Password: ");
		facultyConfirmPasswordField = new JPasswordField(10);
		invalidDataLabel = new JLabel("Invalid Data!");
		invalidDataLabel2 = new JLabel("Invalid Data!");
		nextButton  = new JButton("Next");
		facultyController = controller;

	
		DefaultComboBoxModel securityQuestionModel = new DefaultComboBoxModel();
		securityQuestionModel.addElement("What is the name of your first teacher?");
		securityQuestionModel.addElement("What was your first pet?");
		securityQuestionModel.addElement("Who is your best friend?");
		facultySecurityQuestionBox.setModel(securityQuestionModel);
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(20,15,20,15);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultyIDLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyIDField, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultyUsernameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyUsernameField, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultySecurityQuestionLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultySecurityQuestionBox, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultySecurityAnswerLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultySecurityAnswerField, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultyPasswordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyPasswordField, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultyConfirmPasswordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyConfirmPasswordField, gc);
		
		gc.insets = new Insets(20,0,20,0);
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(invalidDataLabel, gc);
		invalidDataLabel.setVisible(false);
		
		gc.weighty = 2;
		gc.gridx = 1;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(nextButton, gc);
		
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(Arrays.equals(facultyPasswordField.getPassword(),facultyConfirmPasswordField.getPassword())
						 && facultyController.setpassword(Integer.parseInt( facultyIDField.getText() ),
								 facultyUsernameField.getText(),
									facultyPasswordField.getPassword(), (String)facultySecurityQuestionBox.getSelectedItem(), 
									facultySecurityAnswerField.getText()) ) {
					clickListener.clickedNum(-1);		
				}
				else {
					invalidDataLabel.setVisible(true);
				}
			}	
		});
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
}
