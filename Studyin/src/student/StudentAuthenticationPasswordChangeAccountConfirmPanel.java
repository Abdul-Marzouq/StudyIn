package student;

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

import dataController.StudentController;
import events.ClickListener;

public class StudentAuthenticationPasswordChangeAccountConfirmPanel extends JPanel {
	
	private JLabel studentIDLabel;
	private JTextField studentIDField;
	private JLabel studentUsernameLabel;
	private JTextField studentUsernameField;
	private JLabel studentSecurityQuestionLabel;
	private JComboBox studentSecurityQuestionBox;
	private JLabel studentSecurityAnswerLabel;
	private JTextField studentSecurityAnswerField;
	private JLabel studentPasswordLabel;
	private JPasswordField studentPasswordField;
	private JLabel studentConfirmPasswordLabel;
	private JPasswordField studentConfirmPasswordField; 
	private JLabel invalidDataLabel;
	private JLabel invalidDataLabel2;
	private JButton nextButton;
	private StudentController studentController;
	private ClickListener clickListener;
	
	public StudentAuthenticationPasswordChangeAccountConfirmPanel(StudentController controller) {
	
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		studentIDLabel = new JLabel("Student ID: ");
		studentIDField = new JTextField(5);
		studentUsernameLabel = new JLabel("Username: ");
		studentUsernameField = new JTextField(10);
		studentSecurityQuestionLabel = new JLabel("Security Question: ");
		studentSecurityQuestionBox = new JComboBox();
		studentSecurityAnswerLabel = new JLabel("Answer: ");
		studentSecurityAnswerField = new JTextField(10);
		studentPasswordLabel = new JLabel("New Password: ");
		studentPasswordField = new JPasswordField(10);
		studentConfirmPasswordLabel = new JLabel("Confirm Password: ");
		studentConfirmPasswordField = new JPasswordField(10);
		invalidDataLabel = new JLabel("Invalid Data!");
		invalidDataLabel2 = new JLabel("Invalid Data!");
		nextButton  = new JButton("Next");
		studentController = controller;

	
		DefaultComboBoxModel securityQuestionModel = new DefaultComboBoxModel();
		securityQuestionModel.addElement("What is the name of your first teacher?");
		securityQuestionModel.addElement("What was your first pet?");
		securityQuestionModel.addElement("Who is your best friend?");
		studentSecurityQuestionBox.setModel(securityQuestionModel);
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(20,15,20,15);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentIDLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentIDField, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentUsernameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentUsernameField, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentSecurityQuestionLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentSecurityQuestionBox, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentSecurityAnswerLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentSecurityAnswerField, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentPasswordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentPasswordField, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentConfirmPasswordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentConfirmPasswordField, gc);
		
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
				if(Arrays.equals(studentPasswordField.getPassword(),studentConfirmPasswordField.getPassword())
						 && studentController.setpassword(Integer.parseInt( studentIDField.getText() ),
								 studentUsernameField.getText(),
									studentPasswordField.getPassword(), 1, 
									studentSecurityAnswerField.getText()) ) {
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
