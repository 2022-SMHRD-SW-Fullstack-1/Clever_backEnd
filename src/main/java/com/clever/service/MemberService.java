package com.clever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.MemberMapper;
import com.clever.model.Member;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	public int joinMember(Member join_info) {
		return memberMapper.joinMember(join_info);
	}
	
	public Member loginMember(Member login_info) {
		return memberMapper.loginMember(login_info);
	}
	

}
