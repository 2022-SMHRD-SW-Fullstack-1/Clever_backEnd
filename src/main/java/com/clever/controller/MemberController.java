package com.clever.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Member;
import com.clever.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("/join")
	public int joinMember(@RequestBody Member join_info) {
		return memberService.joinMember(join_info);
	}
	
	@PostMapping("/login")
	public Member loginMember(@RequestBody Member login_info) {
		return memberService.loginMember(login_info);
	}
}
