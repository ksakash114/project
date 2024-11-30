package com.crmapi.Employecontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.crmapi.Employeservice.EmployeService;
import com.crmapi.dto.Employedto;
import com.crmapi.entity.Employe;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

	private EmployeService employeservice;
	
	public EmployeController(EmployeService employeservice)
	{
		this.employeservice=employeservice;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addemployes(@Valid @RequestBody Employe employe, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employe emp = employeservice.addemploye(employe);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	@DeleteMapping()
	public ResponseEntity<String> DeleteEmpolyes(@RequestParam Long id)
	{
		employeservice.deleteemploye(id);
		return new ResponseEntity<String>("Record Deleted Successfully",HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Employe> updateemployess(@RequestParam Long id , @RequestBody Employedto dto)
	{
		Employe updateemp = employeservice.updateEmploye(id,dto);
		return new ResponseEntity<Employe>(updateemp,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employe>> getallemployes(
			@RequestParam(name="pageno",required = false,defaultValue = "0")int pageno,
			@RequestParam(name="pageleng",required = true,defaultValue = "5")int pageleng,
			@RequestParam(name="sortfield",required = true,defaultValue = "name")String sortfield,
			@RequestParam(name="sortdir",required = true,defaultValue = "desc")String sortdir
			
			
			
			)
	{
		List<Employe> allemp = employeservice.getallemployess(pageno,pageleng,sortfield,sortdir);
		return new ResponseEntity<List<Employe>>(allemp,HttpStatus.OK);
	}
}
