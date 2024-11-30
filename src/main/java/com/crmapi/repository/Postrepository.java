package com.crmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmapi.entity.Post;

public interface Postrepository extends JpaRepository<Post,Long> {

}
