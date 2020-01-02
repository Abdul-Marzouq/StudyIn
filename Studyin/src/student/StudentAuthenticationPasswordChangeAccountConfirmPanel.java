package student;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentAuthenticationPasswordChangeAccountConfirmPanel extends JPanel {
	
	private JLabel studentIDLabel;
	private JTextField studentIDField;
	private JLabel studentUsernameLabel;
	private JTextField studentUsernameField;
	private JLabel studentSecurityQuestionLabel;
	private JComboBox studentSecurityQuestionBox;
	private JLabel studentSecurityAnswerLabel;
	private JTextField studentSecurityAnswerField;
	private JLabel invalidDataLabel;
	private JButton nextButton;
	
	public StudentAuthenticationPasswordChangeAccountConfirmPanel() {
	
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
		invalidDataLabel = new JLabel("Invalid Data!");
		nextButton  = new JButton("Next");
	
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
		
		gc.insets = new Insets(20,0,20,0);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(invalidDataLabel, gc);
		
		gc.weighty = 2;
		gc.gridx = 1;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(nextButton, gc);
		
	}
}
