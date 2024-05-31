package com.lwj.blog.model;
import java.sql.Timestamp;
import java.util.List;

//영속성 관련 import
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
//lombok 관련 import
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; //시퀀스, auto_increment
	
	@Column(nullable=false, length=200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne // Many=Board, User = One'
	@JoinColumn(name="userId")//외래 키로 만든다. 필드값은 userId로 저장된다는 뜻이다.
	private User user; //db 불러오기

	// mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
	// "board"는 Reply 테이블의 board 필드명
	// @JoinColumn(name = "replyId") // 이걸 적는다면 FK가 생기는데 단순히 join을 할 뿐이지 FK를 만들 필요는 없다.
	// 게다가 여러개의 댓글이 있을경우 1,2,3,4.. 처럼 콤마로 구분돼어 들어간다. 1NF(1정규화)가 깨진다.
	@CreationTimestamp
	private Timestamp createDate;
}
