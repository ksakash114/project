package com.crmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crmapi.entity.Comments;

import jakarta.transaction.Transactional;

@Repository
public interface Commentsrepository extends JpaRepository<Comments, Long> {

	@Modifying
	@Transactional
	@Query("delete from Comments e where e.post.id =:n")
	public void deletebypost_id(@Param("n")long id);
	
}
