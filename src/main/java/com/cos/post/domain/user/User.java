package com.cos.post.domain.user;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cos.post.domain.comment.Comment;
import com.cos.post.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter,Setter 합쳐져 있음.+ toString() 구현되어 있음
//@Getter
//@Setter
@AllArgsConstructor //전체 파라메터를 가진 생성자
@NoArgsConstructor // 파라메터가 없는 생성자
@Builder //빌더 패턴
@Entity //ORM 가능 object relation mapping !!
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//해당데이터베이스 번호증가 전략
		private int id;
		@Column(unique=true)
		private String username;
		private String password;
		private String email;
		
		//나는 연관관계의 주인이 아니야!!(나는 FK를 가진 아이가 아니니까 DB만들지마)
		@JsonIgnoreProperties({"user"}) //중괄호 안에 무시하고싶은 변수"user"
		@OneToMany(mappedBy = "user")  //Post 오브젝트의 user변수를 걸어야함.
		private List<Post> posts;

		
}
