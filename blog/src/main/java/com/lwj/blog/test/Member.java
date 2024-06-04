package com.lwj.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@RequiredArgsConstructor //final이 붙은 사람들에 대한 생성자 생성
@Getter
@Setter
@Data//getter + setter
//@AllArgsConstructor//생성자 생성
@NoArgsConstructor//기본 생성자 생성
public class Member {
	private int id;
	private String userName;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
}

