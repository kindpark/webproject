package com.lwj.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {
	//http://localhost:8001/blog/
	//http://localhost:8001/blog
	@GetMapping({"","/"})
	public String index() {
		// /WEB-INF/views/index.jsp 와 같음
		return "index";
	}
}

