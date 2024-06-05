package com.web.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	private static final String tag = "HttpControllerTest : ";
	//http://localhost:8001/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//메소드 체이닝
		//본래는 Member m = new Member('')과 같은 방식
		Member member = Member.builder().userName("abcd").password("abcd").email("abc@naver.com").build();
		System.out.println(tag + "getter : " + member.getId());
		member.setId(1000);
		System.out.println(tag + "setter : " + member.getId());
		return "test finish";
	}
}

