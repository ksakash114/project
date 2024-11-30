package com.crmapi.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class Employedto {

	
	private long id;
	@NotBlank(message="name cant be null")
	private String name;
	private String emailid;
	
	@Size(min=10,max=10,message="number cant be more then 10 digits")
	private String mobile;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getemailid() {
		return emailid;
	}

	public void setemailid(String emailid) {
		this.emailid = emailid;
	}

	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	
	
}

