package com.praveen.notes;

public class UserModel {
	String name="";
	String date="";
	String subject="";
	public UserModel(String name, String date, String subject) {
		this.name = name;
		this.date = date;
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


}
