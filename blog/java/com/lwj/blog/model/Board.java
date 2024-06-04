package com.lwj.blog.model;
import java.sql.Timestamp;
import java.util.*;

//..*쓰면 에러남
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

import org.hibernate.annotations.*;

//lombok 불러오기
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //GeneratedValue로 타입을 받아와야 빨간줄 사라짐
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob //대용량 데이터
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) // Many=Board, User = One'
	// 한명은 여러개의 게시물을 작성 가능함
	//EAGER -> 항상 데이터를 들고온다. Board를 선택할때 항상 user 테이블까지 함께 조회함
	//LAZY -> 반대되는 개념, 필요할때만 가져온다고 함
	@JoinColumn(name="userId")//외래 키로 만든다. 필드값은 userId로 저장된다는 뜻이다.
	private User user; //db 불러오기
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	// mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
	// "board"는 Reply 테이블의 board 필드명
	// @JoinColumn(name = "replyId") // 이걸 적는다면 FK가 생기는데 단순히 join을 할 뿐이지 FK를 만들 필요는 없다.
	// 게다가 여러개의 댓글이 있을경우 1,2,3,4.. 처럼 콤마로 구분돼어 들어간다. 1NF(1정규화)가 깨진다.
	private List<Reply> reply; // 하나의 글에는 여러개의 댓글이 가능하기 때문에 List 로  가져와야된다.
	
	@CreationTimestamp
	private Timestamp createDate;
}

