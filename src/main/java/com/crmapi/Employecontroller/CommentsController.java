package com.crmapi.Employecontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crmapi.Employeservice.Commentsservice;
import com.crmapi.entity.Comments;
import com.crmapi.entity.Post;
import com.crmapi.repository.Commentsrepository;
import com.crmapi.repository.Postrepository;


@RestController
@RequestMapping("/api/post/comments")
public class CommentsController {

	
	private Postrepository postrepository;
	private Commentsrepository commentsrepository;
	private Commentsservice commentsservice;
	public CommentsController(Postrepository postrepository, Commentsrepository commentsrepository , Commentsservice commentsserivce) {
		super();
		this.postrepository = postrepository;
		this.commentsrepository = commentsrepository;
		this.commentsservice=commentsserivce;
	}
	
     
	@PostMapping("/add")
	public String addcomments(@RequestBody Comments comments,
			@RequestParam long postId)
	{
		Post post = postrepository.findById(postId).get();
		comments.setPost(post);
		commentsrepository.save(comments);
		return "comment added";
	}
	
	@DeleteMapping("/delete")
	public String deletecomment(@RequestParam long postid)
	{
		commentsservice.deletebypostid(postid);
		return "comment deleted";
	}
}
