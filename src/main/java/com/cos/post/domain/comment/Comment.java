package com.cos.post.domain.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.post.domain.post.Post;
import com.cos.post.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter,Setter 합쳐져 있음.+ toString() 구현되어 있음
@AllArgsConstructor //전체 파라메터를 가진 생성자
@NoArgsConstructor // 파라메터가 없는 생성자
@Builder //빌더 패턴
@Entity //ORM 가능 object relation mapping !!
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//해당데이터베이스 번호증가 전략
	private int id;
	private String reply;
	
	@JoinColumn(name="postId")
	@ManyToOne //foreign key 설정
	private Post post;
	
	// User -> Posts 를 호출 할 때만 무시
	@JoinColumn(name="userId")
	@ManyToOne //foreign key 설정
	private User user;
		
	
}
