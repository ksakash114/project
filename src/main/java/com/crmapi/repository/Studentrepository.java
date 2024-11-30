package com.crmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crmapi.entity.Student;

public interface Studentrepository extends JpaRepository<Student,Long> {

	
	/*
	 * @Query("select e from students e where e.marks>=:marks") List<Student>
	 * findallstudentsbymarks(@Param("marks") Integer marks);
	 */
}
