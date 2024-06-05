package com.web.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}

