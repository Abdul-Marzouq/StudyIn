package student;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataController.StudentController;
import events.ClickListener;
import events.FormEvent;

public class StudentAuthenticationSignUpAccountConfirmPanel extends JPanel{
	
	private JLabel studentIDLabel;
	private JTextField studentIDField;
	private JLabel studentNameLabel;
	private JTextField studentNameField;
	private JLabel studentConfirmationNumberLabel;
	private JTextField studentConfirmationNumberField;
	private JLabel invalidDataLabel;
	private JButton nextButton;
	
	private StudentController studentController;
	private ClickListener clickListener;
	
	public StudentAuthenticationSignUpAccountConfirmPanel(StudentController controller) {
		
		setVisible(true);
		
		studentIDLabel = new JLabel("Student_ID: ");
		studentIDField = new JTextField(4);
		studentNameLabel = new JLabel("Student Name: ");
		studentNameField = new JTextField(12);
		studentConfirmationNumberLabel = new JLabel("Confirmation Number: ");
		studentConfirmationNumberField = new JTextField(5);
		invalidDataLabel = new JLabel(" ");
		nextButton = new JButton("Next");
		studentController = controller;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(35,15,20,15);
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
		add(studentNameLabel, gc);	
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentNameField, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(studentConfirmationNumberLabel, gc);	
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentConfirmationNumberField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(studentConfirmationNumberField, gc);
		
		gc.insets = new Insets(35,0,20,0);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.SOUTHEAST;
		add(invalidDataLabel, gc);
		
		gc.weighty = 2;
		gc.gridx = 1;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.EAST;
		add(nextButton, gc);	
		
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(studentController.signupconfirm( Integer.parseInt( studentIDField.getText() ),
												studentNameField.getText(),
												Integer.parseInt( studentConfirmationNumberField.getText() ) ) && 
						!studentController.getStudentbyID(Integer.parseInt( studentIDField.getText())).isAccount_Status()	)	
					clickListener.clickedNum(Integer.parseInt(studentIDField.getText()));
				else {
					invalidDataLabel.setText("Invalid Data!");
				}
			}	
		});
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
}
