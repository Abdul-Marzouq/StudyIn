package admin;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dataController.StudentController;
import events.ClickListener;
import events.FormEvent;
import events.FormListener;

public class AdminStudentCreateUpdateDialog extends JDialog{
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JButton createAccountButton;
	private JButton updateAccountButton;
	private FormListener formListener;
	private ClickListener clickListener;
	private StudentController studentController;
	private int id;
	
	public AdminStudentCreateUpdateDialog(JFrame parent,String title,StudentController s) {
		super(parent, title, false);
		setLayout(new GridBagLayout());
		
		studentController = s;
		
		GridBagConstraints gc = new GridBagConstraints();
		
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(20);
		ageLabel = new JLabel("Age: ");
		ageField = new JTextField(10);
		createAccountButton = new JButton("Create Account");
		updateAccountButton = new JButton("Update Account");
		
		createAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				int age = Integer.parseInt(ageField.getText()); 
				studentController.addStudent(name, age);
				clickListener.clickedNum(100);
			}
		});
		
		updateAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name  = nameField.getText();
				int age = Integer.parseInt(ageField.getText()); 
				studentController.updateStudentbyID(id,name, age);
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

////////////////////Row 3//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.CENTER;
		if(title.equals("Create Student Account"))
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
	}
	
	public void setupdateinfo() {
		nameField.setText(this.studentController.getStudentbyID(id).getStudentName());
		ageField.setText((Integer.toString(this.studentController.getStudentbyID(id).getStudentAge())));
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
}
	
