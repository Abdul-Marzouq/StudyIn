package events;

import java.util.EventObject;

public class LoginFormEvent extends EventObject{

	String username;
	String pwd;
	
	public LoginFormEvent(Object source) {
		super(source);
	}
	
	public LoginFormEvent(Object source,String uName,String pwd) {
		super(source);
		this.pwd = pwd;
		this.username = uName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
