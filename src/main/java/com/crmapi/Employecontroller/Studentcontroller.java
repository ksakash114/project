package com.crmapi.Employecontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crmapi.Employeservice.Studentservice;
import com.crmapi.dto.Studentdto;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/students/v1")
public class Studentcontroller {

	private Studentservice studentservice;
	
	public Studentcontroller(Studentservice studentservice)
	{
		this.studentservice=studentservice;
	}
	
	
	
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createstudent(@Valid @RequestBody Studentdto dto, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Studentdto stu = studentservice.createstudents(dto);
		return new ResponseEntity<>(stu,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Studentdto> updatestudent(@RequestParam Long rollno,@RequestBody Studentdto dto)
	{
		Studentdto updatestudentdata = studentservice.updatestudent(rollno,dto);
		return new ResponseEntity<>(updatestudentdata,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<Studentdto>> getallStudents(
			@RequestParam(name="pageno",required = false,defaultValue = "0")int pageno,
			@RequestParam(name="pagelimit",required = false,defaultValue = "15")int pagelimit,
			@RequestParam(name="sortname",required = false,defaultValue = "name")String sortname,
			@RequestParam(name="sortdir",required = false,defaultValue = "asc")String sortdir
			
			)
	{
		List<Studentdto> listofstudents = studentservice.getallstudentsrecords(pageno,pagelimit,sortname,sortdir);
		return new ResponseEntity<List<Studentdto>>(listofstudents,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/studentid/{rollno}")
	public ResponseEntity<Studentdto> getallStudents(@PathVariable Long rollno)
	{
		Studentdto students = studentservice.getstudentbyrollno(rollno);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
}
