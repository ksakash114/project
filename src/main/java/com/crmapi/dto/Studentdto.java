
package com.crmapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class Studentdto {

	private long rollno;
	private String name;
	private String section;
	@Max(value=2,message="marks should not be more then 2")
	private int marks;
	//private Date createddate;
	private String msg;

	
	  public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getRollno() {
		  return rollno; 
		  } 
	  public void setRollno(Long rollno)
	  { 
		  this.rollno = rollno; 
	  }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	/*
	 * public Date getCreateddate() { return createddate; } public void
	 * setCreateddate(Date createddate) { this.createddate = createddate; }
	 */
	
	
}
