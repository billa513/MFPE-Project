package com.example.newhospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

	private String id;
	private String role;
	@Id
	private String userName;
	private String password;
	
	
	public Login(String id, String role, String userName, String password) {
		super();
		this.id = id;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}
	public Login() {
		super();
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
