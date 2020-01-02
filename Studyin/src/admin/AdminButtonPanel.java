package admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import events.ClickListener;

public class AdminButtonPanel extends JPanel implements ActionListener{
	
	private JButton csa;
	private JButton cfa;
	private JButton dsa;
	private JButton dfa;
	private JButton esa;
	private JButton efa;
	private JButton ssd;
	private JButton sfd;
	private ClickListener listener;

	public AdminButtonPanel() {
		
		setLayout(new GridLayout(8,0));
		
		Border innerBorder = BorderFactory.createTitledBorder("Menu");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		csa = new JButton("Create Student Account");
		cfa = new JButton("Create Faculty Account");
		esa = new JButton("Edit Student Account");
		efa = new JButton("Edit Faculty Account");
		dsa = new JButton("Delete Student Account");
		dfa = new JButton("Delete Faculty Account");
		ssd = new JButton("Show Student Database");
		sfd = new JButton("Show Faculty Database");
		//GridBagConstraints gc = new GridBagConstraints();
		
		csa.addActionListener(this);
		cfa.addActionListener(this);
		esa.addActionListener(this);
		efa.addActionListener(this);
		dsa.addActionListener(this);
		dfa.addActionListener(this);
		ssd.addActionListener(this);
		sfd.addActionListener(this);
		
		add(csa);
		add(esa);
		add(dsa);
		add(ssd);
		add(cfa);
		add(efa);
		add(dfa);
		add(sfd);
	}
	
	public void setClicklistener(ClickListener cl) {
		this.listener = cl;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		if(clicked == csa) {
				if(listener != null) {
					listener.clickedNum(1);
				}
		}
		 else if(clicked == esa) {
			if(listener != null) {
				listener.clickedNum(2);
			}
		}
		else if(clicked == dsa) {
				if(listener != null) {
					listener.clickedNum(3);
				}
		}
		else if(clicked == ssd) {
			if(listener != null) {
				listener.clickedNum(4);
			}
		}
		else if(clicked == cfa) {
			if(listener != null) {
				listener.clickedNum(5);
			}
		}
		
		else if(clicked == efa) {
			if(listener != null) {
				listener.clickedNum(6);
			}
		}
		else if(clicked == dfa) {
				if(listener != null) {
					listener.clickedNum(7);
				}
		}
		else if(clicked == sfd) {
				if(listener != null) {
					listener.clickedNum(8);
				}
		}
	}
}
	
