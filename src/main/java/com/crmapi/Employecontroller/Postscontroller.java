package com.crmapi.Employecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crmapi.entity.Post;
import com.crmapi.repository.Commentsrepository;
import com.crmapi.repository.Postrepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/posts")
public class Postscontroller {

	@Autowired
	private Postrepository postrepository;
	@Autowired
	private Commentsrepository commentsrepository;
	
	
	
	
	public Postscontroller(Postrepository postrepository, Commentsrepository commentsrepository) {
		super();
		this.postrepository = postrepository;
		this.commentsrepository = commentsrepository;
	}




	@PostMapping("/add")
	public String postMethodName(@RequestBody Post post) {
		//TODO: process POST request
		postrepository.save(post);
		return "saved";
	}
	
	@DeleteMapping("/delete")
	public String Deletepost(@RequestParam Long id)
	{
		postrepository.deleteById(id);
		return "record deleted";
	}
	
}
