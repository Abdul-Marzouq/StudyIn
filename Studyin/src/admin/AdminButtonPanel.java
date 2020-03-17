package admin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import events.ClickListener;

public class AdminButtonPanel extends JPanel implements ActionListener{
	
	private JButton cr;
	private JButton u;
	private JButton d;

	private ClickListener listener;

	public AdminButtonPanel() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 45, 5));
		
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(3,3,3,3);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		cr = new JButton("Create");
		cr.addActionListener(this);
		add(cr);
		
		u = new JButton("Update");
		u.addActionListener(this);
		add(u);
		
		d = new JButton("Delete");
		d.addActionListener(this);
		add(d);
	}
	
	public void setClicklistener(ClickListener cl) {
		this.listener = cl;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		if(clicked == cr)  {
			if(listener != null) {
				listener.clickedNum(1);
			}
		}
		else if(clicked == u)  {
			if(listener != null) {
				listener.clickedNum(2);
			}
		}
		else if(clicked == d)  {
			if(listener != null) {
				listener.clickedNum(3);
			}
		}
	}
}
	
