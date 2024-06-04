package com.lwj.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/joinForm")
	public String joinForm() { // 회원가입 폼 띄우는 메서드 
		return "user/joinForm";
	}
	
	@GetMapping("/user/loginForm")
	public String loginForm() { // 로그인 폼 띄우는 메서드 
		return "user/loginForm";
	}
}

