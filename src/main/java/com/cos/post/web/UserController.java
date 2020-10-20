package com.cos.post.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //final이 걸린 생성자 초기화.
public class UserController {
	
	private final UserRepository userRepository;
	
	@PostMapping("/user")
	public String 회원가입(@RequestBody User user) {
		userRepository.save(user);
		return "ok";
	}
	@GetMapping("/user")
	public List<User> 유저목록(){
		return userRepository.findAll();
	}
	@GetMapping("/user/{id}")
	public User 유저상세(@PathVariable int id){
		User user = userRepository.findById(id).get(); //여기까지는 posts는 null값
		return user; //return 할때 LazyLoading(지연로딩이발동)
	}
}
