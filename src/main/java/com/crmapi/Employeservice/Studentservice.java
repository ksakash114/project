package com.crmapi.Employeservice;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crmapi.dto.Studentdto;
import com.crmapi.entity.Student;
import com.crmapi.exceptions.NoValuePresent;
import com.crmapi.repository.Studentrepository;
@Service
public class Studentservice {

	private Studentrepository studentrepository;
	private ModelMapper mapper;
	
	public Studentservice(Studentrepository studentrepository,ModelMapper mapper)
	{
		this.studentrepository=studentrepository;
		this.mapper=mapper;
	}

	public Studentdto createstudents(Studentdto studentdto) {
		// TODO Auto-generated method stub
		Student student = maptoentity(studentdto);
		Student savestudent = studentrepository.save(student);
		Studentdto returndto = maptodto(savestudent);
		//returndto.setCreateddate(new Date());
		return returndto;
	}
	
	public Studentdto maptodto(Student student)
	{
		Studentdto studentdto = mapper.map(student,Studentdto.class);
		/*
		 * Studentdto studentdto = new Studentdto();
		 * studentdto.setRollno(student.getRollno());
		 * studentdto.setName(student.getName());
		 * studentdto.setSection(student.getSection());
		 * studentdto.setMarks(student.getMarks());
		 */
		return studentdto;
	}
	
	public Student maptoentity(Studentdto studentdto)
	{
		Student student = mapper.map(studentdto,Student.class);
		/*
		 * Student student = new Student(); student.setRollno(studentdto.getRollno());
		 * student.setName(studentdto.getName());
		 * student.setSection(studentdto.getSection());
		 * student.setMarks(studentdto.getMarks());
		 */
		return student;
	}

	public Studentdto updatestudent(Long rollno, Studentdto dto) {
		// TODO Auto-generated method stub
		Student studententity = maptoentity(dto);
		studententity.setRollno(rollno);
		Student studentdata = studentrepository.save(studententity);
	      Studentdto studentdto = maptodto(studentdata);
		return studentdto;
	}

	public List<Studentdto> getallstudentsrecords(int pageno, int pagelimit, String sortname,String sortdir) {
		// TODO Auto-generated method stub
		Sort sorting = sortdir.equalsIgnoreCase("asc")?Sort.by(sortname).ascending():Sort.by(sortname).descending();
		Pageable pagination = PageRequest.of(pageno, pagelimit,sorting);
		Page<Student> all = studentrepository.findAll(pagination);
		List<Student> listofstudents = all.getContent();
		List<Studentdto> listofstudentsdto = listofstudents.stream().map(e->maptodto(e)).collect(Collectors.toList());
		return listofstudentsdto;
	}

	public Studentdto getstudentbyrollno(Long rollno) {
		// TODO Auto-generated method stub
		 Student student = studentrepository.findById(rollno).orElseThrow(
				 ()->new NoValuePresent("No record found with rollno : " + rollno)
				 
				 );
		Studentdto studentdto = maptodto(student);
		return studentdto;
	}
	
	
}
