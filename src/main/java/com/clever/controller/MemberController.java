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
	public int joinMember(@RequestBody Member mem_info) {
		return memberService.joinMember(mem_info);
	}
	
	@PostMapping("/login")
	public void loginMember(@RequestBody Member mem_info) {
		
	}
}
