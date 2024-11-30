package com.crmapi.dto;

import java.util.Date;

import org.springframework.web.context.request.WebRequest;

public class StudentErrordetails {

	
	private Date date;
	private String msg;
	private String request;
	
	public StudentErrordetails(Date date, String msg, String request) {
		super();
		this.date = date;
		this.msg = msg;
		this.request = request;
	}
	public Date getDate() {
		return date;
	}
	public String getMsg() {
		return msg;
	}
	public String getRequest() {
		return request;
	}
	
	
	
}
