package admin;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import dataController.FacultyController;
import dataModel.Faculty;
import events.ClickListener;

public class AdminFacultyDeletePanel extends JPanel{
	
	private AdminFacultyDeleteInfoPanel adsip;
	private AdminFacultyDeleteIDCheckPanel adsicp;
	private FacultyController facultyController;
	private Faculty faculty;
	private ClickListener clickListener;
	
	public AdminFacultyDeletePanel(FacultyController s) {
		
		adsicp = new AdminFacultyDeleteIDCheckPanel(s);
		adsip = new AdminFacultyDeleteInfoPanel();
		facultyController = s;
		
		setLayout(new BorderLayout());
		
		add(adsicp, BorderLayout.CENTER);
		
		adsicp.setFacultyController(facultyController);
		
		adsicp.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				if(clickStatus >= 0) {
					faculty = facultyController.getFacultybyID(clickStatus);
					adsip.setFaculty(faculty);
					add(adsip, BorderLayout.CENTER);
					adsicp.setVisible(false);
					adsip.setVisible(true);
				}
				else {
					add(adsicp, BorderLayout.CENTER);
					adsicp.setVisible(true);
					adsip.setVisible(false);
				}
			}
		});
		
		adsip.setClickListener(new ClickListener() {
			public void clickedNum(int clickStatus) {
				facultyController.deleteFacultybyID(faculty.getFacultyId());
				clickListener.clickedNum(100);
				add(adsicp, BorderLayout.CENTER);
				adsicp.setVisible(true);
				adsip.setVisible(false);
			}	
		});
	}
	
	public void setFacultyController(FacultyController controller) {
		this.facultyController = controller;
	}
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void clearTextField() {
		adsicp.resetTextField();
	}
}
