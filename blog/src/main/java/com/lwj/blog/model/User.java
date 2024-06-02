package com.lwj.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ORM -> java(다른언어) Object --> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다. // 이 어노테이션이 가장 가까이 있는게 좋다
//@DynamicInsert
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. 
	// application.yml에서 use-new-id-generator-mappings: false 설정돼있어야함
	private int id;	// 시퀀스, mySQL : auto_increment // 자동으로 들어갈꺼임
	  
	@Column(nullable=false, length = 30)
	private String userName; // 아이디
	
	@Column(nullable=false, length = 100) 
	//112312를 해싱하면 엄청 길어짐
	private String password; // 비밀번호
	
	@Column(nullable=false, length = 50)
	private String email; // 이메일
	
	@Enumerated(EnumType.STRING) // 문자열인걸 알려주기 위해 ""안에 '' 를 사용한다
	private RoleType role; // Enum을 쓰는게 좋다. // admin, user, manager 
	// Enum을 쓰면 도메인설정을 가능하게 한다. admin, user, manager만 들어가게 할 수 있다.
	
	@CreationTimestamp // 현재시간으로 시간이 자동 입력
	private Timestamp createDate;
	
	// 스프링 실행하면 동작한다 . 단 서비스에서 mySQL이 동작중이어야한다.
}