package com.supinfo.supmessage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int M_id;
	private String  Sname;
	private String  Dname;
	private String  message;
	private String  time;
	
	public Message(){ }
	
	public Message(String sname, String dname , String time ,String message){
		this.Sname = sname;
		this.Dname = dname;
		this.time = time;
		this.message = message;
		
	}

	public int getM_id() {
		return M_id;
	}

	public void setM_id(int m_id) {
		M_id = m_id;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
