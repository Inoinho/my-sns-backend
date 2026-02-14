package com.mysite.sns;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000",
		"https://my-sns-project-one.vercel.app/"})
@RequiredArgsConstructor
public class UserController {
	
	private final UserRepository userRepository;

	// 1. 모든 유저 조회
	@GetMapping("/users")
	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}
	
	// 2. 유저 추가
	@PostMapping("/users")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userRepository.save(user);
	}
	
	// 3. 유저 삭제
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
}
