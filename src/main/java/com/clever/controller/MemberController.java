package com.clever.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Join;
import com.clever.model.Member;
import com.clever.service.MemberService;


@RequestMapping("/member")
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
	
	@PostMapping("/group/list")
	public List<Join> getGroupMemList(@RequestBody Join group_info) {
		return memberService.getGroupMemList(group_info);
	}
	
	@PostMapping("/group/delete")
	public int deleteGroupMem(@RequestBody Join join_info) {
		return memberService.deleteGroupMem(join_info);
	}
}
