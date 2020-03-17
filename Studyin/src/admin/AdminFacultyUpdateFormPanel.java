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

import dataModel.Faculty;
import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminFacultyUpdateFormPanel extends JPanel{
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JLabel subLabel;
	private JTextField subField;
	private JButton updateAccountButton;
	private FormListener formListener;
	private ClickListener clickListener;
	private Faculty faculty;
	
	public AdminFacultyUpdateFormPanel() {
		
		setVisible(true);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		faculty = new Faculty();
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(20);
		ageLabel = new JLabel("Age: ");
		ageField = new JTextField(10);
		subLabel = new JLabel("Subject: ");
		subField = new JTextField(15);
		updateAccountButton = new JButton("Update Account");
	
		Border innerBorder = BorderFactory.createTitledBorder("Update Faculty Account");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		updateAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				String age = ageField.getText(); 
				String sub = subField.getText(); 
				
				FormEvent event = new FormEvent(this, name, age,sub);
				
				if(formListener != null) {
					formListener.FormEventOccurred(event);
				setVisible(false);
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
		gc.weighty = 0.1;

		gc.gridx = 0;	
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(subLabel, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;	
		add(subField, gc);

////////////////////Row 4//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		add(updateAccountButton, gc);
	}
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
		nameField.setText(faculty.getFacultyName());
		ageField.setText(faculty.getFacultyAge());
	}

}

