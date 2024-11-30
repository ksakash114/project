package com.crmapi.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="employe")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", nullable = true)
	private String name;
	
	@Column(name="email_id", nullable = false , unique = true)
	private String emailid;
	
	@Column(name="mobile",nullable = true, unique = true,length = 10)
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
