package com.lwj.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lwj.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}

