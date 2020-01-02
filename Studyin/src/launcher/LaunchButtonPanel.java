package launcher;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import events.ClickListener;

public class LaunchButtonPanel extends JPanel implements ActionListener{

	private JButton adminButton;
	private JButton facultyButton;
	private JButton studentButton;
	private ClickListener listener;
	
	public LaunchButtonPanel()
	{
		setLayout(new GridBagLayout());
		
		adminButton = new JButton("Admin");
		facultyButton = new JButton("Faculty");
		studentButton = new JButton("Student");
		GridBagConstraints gc = new GridBagConstraints();
		
		adminButton.addActionListener(this);
		facultyButton.addActionListener(this);
		studentButton.addActionListener(this);
	
		
////////////////////Row 1//////////////////////////////////		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		add(adminButton,gc);

////////////////////Row 2//////////////////////////////////
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		add(facultyButton,gc);
		
////////////////////Row 3//////////////////////////////////
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 2;
		add(studentButton,gc);	
		
	}
	
	public void setClickListener(ClickListener cl) {
		this.listener = cl;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == adminButton) {
				if(listener != null) {
					listener.clickedNum(1);
				}
		}
		 else if(clicked == facultyButton) {
			if(listener != null) {
				listener.clickedNum(2);
			}
		}
		else if(clicked == studentButton) {
			if(listener != null) {
				listener.clickedNum(3);
			}
		}
		
		
	}
		
}
