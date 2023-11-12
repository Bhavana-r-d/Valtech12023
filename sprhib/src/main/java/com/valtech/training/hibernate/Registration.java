package com.valtech.training.hibernate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String username;
    private String password;
    private int mobile;
    
    @Embedded
    private RegAddress regaddress;
	public Registration(String username, String password, int mobile, RegAddress regaddress) {
		
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.regaddress = regaddress;
	}
	public Registration() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public RegAddress getRegaddress() {
		return regaddress;
	}
	public void setRegaddress(RegAddress regaddress) {
		this.regaddress = regaddress;
	}
	
	
	
}
