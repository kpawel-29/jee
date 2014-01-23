package com.example.jeedemo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class myUser {
	
	private Long Id;
	private String username;
	private String password;
	public Long getId() {
		return Id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public void setId(Long id) {
		this.Id = id;
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
	
	
	
}
