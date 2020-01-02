package events;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String age;
	private String username;
	private String pwd;
	
	public FormEvent(Object source) {
		super(source);
	}

	
	public FormEvent(Object source, String name, String age) {
		super(source);
		
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
