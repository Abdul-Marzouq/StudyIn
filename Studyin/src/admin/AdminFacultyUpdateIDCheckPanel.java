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

import dataController.FacultyController;
import events.ClickListener;

public class AdminFacultyUpdateIDCheckPanel extends JPanel{
	
	private JLabel idLabel;
	private JTextField idField;
	private JButton searchButton;
	private JLabel notFoundLabel;
	private FacultyController facultyController;
	private ClickListener clickListener;
	
	public AdminFacultyUpdateIDCheckPanel(FacultyController s) {
		idLabel = new JLabel("Enter ID of faculty: ");
		idField = new JTextField(10);
		searchButton = new JButton("Search");
		notFoundLabel = new JLabel(" ");
		facultyController = s;
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facultyController.isID(Integer.parseInt(idField.getText()))) {
					notFoundLabel.setText(" ");
					clickListener.clickedNum(Integer.parseInt(idField.getText()));
				}
				else {
					notFoundLabel.setText("ID not Found.");
				}
			}
		});
		
		GridBagConstraints gc = new GridBagConstraints(); 
		setLayout(new GridBagLayout());
	
		Border innerBorder = BorderFactory.createTitledBorder("Search Faculty Account to Update");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	
		gc.weightx = 1;
		gc.weighty = 0.5;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(10,10,10,10);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(idLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(idField, gc);
		
		gc.weightx = 1;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTHWEST;
		add(searchButton, gc);

		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(notFoundLabel, gc);
			
	}
	public void setFacultyController(FacultyController controller) {
		this.facultyController = controller;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void resetTextField() {
		idField.setText("");
		notFoundLabel.setText(" ");
	}
}
