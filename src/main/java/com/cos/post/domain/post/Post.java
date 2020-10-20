package com.cos.post.domain.post;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cos.post.domain.comment.Comment;
import com.cos.post.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Getter,Setter 합쳐져 있음.+ toString() 구현되어 있음
@AllArgsConstructor //전체 파라메터를 가진 생성자
@NoArgsConstructor // 파라메터가 없는 생성자
@Builder //빌더 패턴
@Entity //ORM 가능 object relation mapping !!
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//해당데이터베이스 번호증가 전략
	private int id;
	private String title;
	@Column(length= 100000)
	private String content;
	private int readCount;
	
	// User -> Posts 를 호출 할 때만 무시
	@JsonIgnoreProperties({"posts"})
	@JoinColumn(name="userId")
	@ManyToOne //foreign key 설정
	private User user;
	//나는 연관관계의 주인이 아니야!!(나는 FK를 가진 아이가 아니니까 DB만들지마)
	@JsonIgnoreProperties({"user","post"}) //중괄호 안에 무시하고싶은 변수"user"
	@OneToMany(mappedBy = "post",fetch = FetchType.EAGER)  //Post 오브젝트의 user변수를 걸어야함.
	private List<Comment> comments;
	
	
}
