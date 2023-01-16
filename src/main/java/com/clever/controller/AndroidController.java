package com.clever.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Member;

@RestController
public class AndroidController {

	@GetMapping("/android/hello")
	public String hello() {

		System.out.println("Hello Android");

		return "Hello Android";
	}
	
	@PostMapping("/android/join")
	public int join(@RequestBody Member join_info) {
		System.out.println(join_info);
		return 1;
	}
	
	@PostMapping("/android/login")
	public String login(@RequestBody Member login_info) {
		System.out.println(login_info);
		return "Login Success";
	}
	

}
