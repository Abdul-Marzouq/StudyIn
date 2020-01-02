package dataModel;

public class Faculty {
	
	private static int count = 0;
	private int FacultyId;
	private String FacultyName;
	private String FacultyAge;
	
	public Faculty(int id,String name, String age) {
		this.FacultyId = id;
		this.FacultyAge = age;
		this.FacultyName = name;
	}
	
	public Faculty() {
		
	}

	public int getFacultyId() {
		return FacultyId;
	}
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}
	public String getFacultyName() {
		return FacultyName;
	}
	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
	public String getFacultyAge() {
		return FacultyAge;
	}
	public void setFacultyAge(String facultyAge) {
		FacultyAge = facultyAge;
	}
}

