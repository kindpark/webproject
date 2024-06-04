package com.lwj.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	//http://localhost:8001/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temphome()");
		//파일 리턴 기본 경로 : src/main/resources/static
		//리턴명 /home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "test";
	}
	@GetMapping("/temp/test")
	public String tempTest() {
		return "test";
	}
}

