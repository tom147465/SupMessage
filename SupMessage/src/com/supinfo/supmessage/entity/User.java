package com.supinfo.supmessage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	@Id
	private String Username;
	private String Password;
	private String nickname;
	private String Email;
	private String address;
	
	public User(){ }
	
	public User(String username, String password, String nickname, String email, String address){
    	this.Username = username;
    	this.Password = password;
    	this.nickname = nickname;
    	this.Email = email;
    	this.address = address;
    }
	
	
	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
