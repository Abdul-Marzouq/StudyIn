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
import javax.swing.border.Border;

import dataModel.Student;
import events.ClickListener;

public class AdminStudentDeleteInfoPanel extends JPanel{
	private JLabel nameLabel;
	private JLabel studentNameLabel;
	private JLabel ageLabel;
	private JLabel studentAgeLabel;
	private JButton deleteAccountButton;
	private ClickListener clickListener;
	private Student student;
	
	public AdminStudentDeleteInfoPanel() {
		setLayout(new GridBagLayout());
		
		nameLabel = new JLabel("Name: ");
		studentNameLabel = new JLabel(" ");
		ageLabel = new JLabel("Age: ");
		studentAgeLabel = new JLabel(" ");
		deleteAccountButton = new JButton("Delete Account");
		student = new Student();
		
		Border innerBorder = BorderFactory.createTitledBorder("Delete Student Account");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		GridBagConstraints gc = new GridBagConstraints();
		
		deleteAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				clickListener.clickedNum(100);
				setVisible(false);
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
		add(studentNameLabel, gc);

////////////////////Row 2//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;	
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTHEAST;
		add(ageLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTHWEST;
		add(studentAgeLabel, gc);

////////////////////Row 3//////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.WEST;
		add(deleteAccountButton, gc);
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void setStudent(Student student) {
		this.student = student;
		studentNameLabel.setText(student.getStudentName());
		studentAgeLabel.setText(student.getStudentAge());
	}

}
