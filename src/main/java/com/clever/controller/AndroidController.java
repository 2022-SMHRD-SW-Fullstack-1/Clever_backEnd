package com.clever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Group;
import com.clever.model.Member;
import com.clever.service.AndroidService;

@RestController
public class AndroidController {
	
	@Autowired
	AndroidService androidService;

	@GetMapping("/android/hello")
	public String hello() {
		System.out.println("Hello Android");
		return "Hello Android";
	}
	
	// 회원가입
	@PostMapping("/android/joinMember")
	public int joinMember(@RequestBody Member join_info) {
		System.out.println("회원가입 받은 데이터 : " + join_info);
		return androidService.joinMember(join_info);
	}
	
	// 로그인
	@PostMapping("/android/login")
	public Member login(@RequestBody Member login_info) {
		System.out.println("로그인 받은 데이터 : " + login_info);
		return androidService.login(login_info);
	}
	
	// mainActivity groupList 가져오기
	@PostMapping("/android/getGroup")
	public List<Group> getGroup(@RequestBody Member user_info){
		System.out.println("로그인한 유저 데이터 : " + user_info);
		return androidService.getGroup(user_info.getMem_id());
	}

}
