package com.crmapi.Employeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crmapi.dto.Employedto;
import com.crmapi.entity.Employe;
import com.crmapi.repository.Employerepository;

@Service
public class EmployeService {

	private Employerepository employerepository;
	
	public EmployeService(Employerepository employerepository)
	{
		this.employerepository=employerepository;
	}
	
	public Employe addemploye(Employe employe)
	{
		Employe emp = employerepository.save(employe);
		return emp;
	}
	public void deleteemploye(Long id) {
		// TODO Auto-generated method stub
		 employerepository.deleteById(id);
	}

	public Employe updateEmploye(Long id, Employedto dto) {
		// TODO Auto-generated method stub
		Optional<Employe> empdata = employerepository.findById(id);
		Employe employe = empdata.get();
		employe.setemailid(dto.getemailid());
		employe.setmobile(dto.getmobile());
		employe.setname(dto.getname());
		employerepository.save(employe);
		return employe;
	}

	public List<Employe> getallemployess(int pageno, int pageleng, String sortfield, String sortdir) {
		// TODO Auto-generated method stub
		Sort sortby = sortdir.equalsIgnoreCase("asc")?Sort.by(sortfield).ascending():Sort.by(sortfield).descending();
		Pageable sortedlist = PageRequest.of(pageno, pageleng, sortby);
		Page<Employe> elist = employerepository.findAll(sortedlist);
		List<Employe> allemp = elist.getContent();
		return allemp;
		
	}

	
	
}
