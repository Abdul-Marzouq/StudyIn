package admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminFacultyCreateFormPanel extends JPanel{
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JButton createAccountButton;
	private FormListener formListener;
	private ClickListener clickListener;
	
	public AdminFacultyCreateFormPanel() {
		
		setVisible(true);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(20);
		ageLabel = new JLabel("Age: ");
		ageField = new JTextField(10);
		createAccountButton = new JButton("Create Account");
		
		Border innerBorder = BorderFactory.createTitledBorder("Create Faculty Account");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		createAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				String age = ageField.getText(); 
				
				FormEvent event = new FormEvent(this, name, age);
				
				if(formListener != null) {
					formListener.FormEventOccurred(event);
					
				clickListener.clickedNum(100);
				}
			}
		});
		
////////////////////Row 1//////////////////////////////////		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(10,10,10,10);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

////////////////////Row 2//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;	
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(ageLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(ageField, gc);

////////////////////Row 3//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.CENTER;
		add(createAccountButton, gc);
		
	}
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
		
	}
	
	public void resetTextField() {
		nameField.setText("");
		ageField.setText("");
	}
	
}
