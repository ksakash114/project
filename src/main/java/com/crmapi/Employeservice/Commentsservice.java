package com.crmapi.Employeservice;

import org.springframework.stereotype.Service;

import com.crmapi.repository.Commentsrepository;
import com.crmapi.repository.Postrepository;

@Service
public class Commentsservice {

	private Postrepository postrepository;
	private Commentsrepository commentsrepository;
	public Commentsservice(Postrepository postrepository, Commentsrepository commentsrepository) {
		super();
		this.postrepository = postrepository;
		this.commentsrepository = commentsrepository;
	}
	
	public void deletebypostid(long postid)
	{
		commentsrepository.deletebypost_id(postid);
	}
}
