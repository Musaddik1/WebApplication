package com.pojo;

public class Login {

	private String username;
	private String password;
	private String confirm;
	private String firstname;
	private String lastname;
	private String DOB;
	private String mobile;
	private String mail;
	public Login()
	{}
	public Login(String username, String password, String confirm, String firstname, String lastname, String dOB,
			String mobile, String mail) {
		super();
		this.username = username;
		this.password = password;
		this.confirm = confirm;
		this.firstname = firstname;
		this.lastname = lastname;
		DOB = dOB;
		this.mobile = mobile;
		this.mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", confirm=" + confirm + ", firstname="
				+ firstname + ", lastname=" + lastname + ", DOB=" + DOB + ", mobile=" + mobile + ", mail=" + mail + "]";
	}
	
}
