package com.web.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.blog.controller.dto.ResponseDto;
import com.web.blog.model.User;
@RestController
public class UserApiController {
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user){
		System.out.println("userApiController 호출됨");
		//Java Class를 JSON으로 변환함
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
}

