package admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataController.FacultyController;
import events.ClickListener;
import events.FormListener;

public class AdminFacultyCreateUpdateDialog extends JDialog{
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JLabel subLabel;
	private JTextField subField;
	private JButton createAccountButton;
	private JButton updateAccountButton;
	private FormListener formListener;
	private ClickListener clickListener;
	private FacultyController facultyController;
	private int id;
	
	public AdminFacultyCreateUpdateDialog(JFrame parent,String title,FacultyController s) {
		super(parent, title, false);
		setLayout(new GridBagLayout());
		
		facultyController = s;
		
		GridBagConstraints gc = new GridBagConstraints();
		
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(20);
		ageLabel = new JLabel("Age: ");
		ageField = new JTextField(10);
		subLabel = new JLabel("Subject: ");
		subField = new JTextField(15);
		createAccountButton = new JButton("Create Account");
		updateAccountButton = new JButton("Update Account");
		
		createAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				int age = Integer.parseInt(ageField.getText()); 
				String sub = subField.getText();
				facultyController.addFaculty(name, age, sub);
				clickListener.clickedNum(100);
			}
		});
		
		updateAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				int age = Integer.parseInt(ageField.getText()); 
				String sub = subField.getText();
				facultyController.updateFacultybyID(id,name, age, sub);
				clickListener.clickedNum(100);
	
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
		
		gc.gridx = 0;	
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(subLabel, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(subField, gc);

////////////////////Row 3//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		if(title.equals("Create Faculty Account"))
			add(createAccountButton, gc);
		else
			add(updateAccountButton,gc);
			
		setSize(600,480);
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
		subField.setText("");
	}
	
	public void setupdateinfo() {
		nameField.setText(this.facultyController.getFacultybyID(id).getFacultyName());
		ageField.setText((Integer.toString(this.facultyController.getFacultybyID(id).getFacultyAge())));
		subField.setText(this.facultyController.getFacultybyID(id).getSubject());
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
}
