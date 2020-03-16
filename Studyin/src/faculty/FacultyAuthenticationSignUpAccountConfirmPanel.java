package faculty;

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

import dataController.FacultyController;
import events.ClickListener;
import events.FormEvent;

public class FacultyAuthenticationSignUpAccountConfirmPanel extends JPanel{
	
	private JLabel facultyIDLabel;
	private JTextField facultyIDField;
	private JLabel facultyNameLabel;
	private JTextField facultyNameField;
	private JLabel facultyConfirmationNumberLabel;
	private JTextField facultyConfirmationNumberField;
	private JLabel invalidDataLabel;
	private JButton nextButton;
	
	private FacultyController facultyController;
	private ClickListener clickListener;
	
	public FacultyAuthenticationSignUpAccountConfirmPanel(FacultyController controller) {
		
		setVisible(true);
		
		facultyIDLabel = new JLabel("Faculty_ID: ");
		facultyIDField = new JTextField(4);
		facultyNameLabel = new JLabel("Faculty Name: ");
		facultyNameField = new JTextField(12);
		facultyConfirmationNumberLabel = new JLabel("Confirmation Number: ");
		facultyConfirmationNumberField = new JTextField(5);
		invalidDataLabel = new JLabel(" ");
		nextButton = new JButton("Next");
		facultyController = controller;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(35,15,20,15);
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
		add(facultyNameLabel, gc);	
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyNameField, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(facultyConfirmationNumberLabel, gc);	
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyConfirmationNumberField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(facultyConfirmationNumberField, gc);
		
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
				if(facultyController.signupconfirm( Integer.parseInt( facultyIDField.getText() ),
												facultyNameField.getText(),
												Integer.parseInt( facultyConfirmationNumberField.getText() ) ) && 
						!facultyController.getFacultybyID(Integer.parseInt( facultyIDField.getText())).isAccount_Status()	)	
					clickListener.clickedNum(Integer.parseInt(facultyIDField.getText()));
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
