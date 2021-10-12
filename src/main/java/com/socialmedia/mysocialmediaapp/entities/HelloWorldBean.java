package com.socialmedia.mysocialmediaapp.entities;

import java.util.Date;

public class HelloWorldBean {

	private int id;
	private String message;
	private Date sysdate;

	public HelloWorldBean() {
	}

	public HelloWorldBean(int id, String message, Date sysdate) {
		this.id = id;
		this.message = message;
		this.sysdate = sysdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [id=" + id + ", message=" + message + ", sysdate=" + sysdate + "]";
	}

	
}
