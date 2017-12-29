package com.supinfo.supmessage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Contact")
public class Contact implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String S_user;
	private String C_user;
	
	public Contact(){ }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contact(String s_user, String c_user) {
		this.S_user = s_user;
    	this.C_user = c_user;
	}
	
	public String getS_user() {
		return S_user;
	}
	public void setS_user(String s_user) {
		S_user = s_user;
	}
	public String getC_user() {
		return C_user;
	}
	public void setC_user(String c_user) {
		C_user = c_user;
	}
	
	
}
