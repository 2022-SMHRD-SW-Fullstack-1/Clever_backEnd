package com.clever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.AndroidMapper;
import com.clever.model.Member;

@Service
public class AndroidService {
	
	@Autowired
	AndroidMapper androidMapper;

	// 회원가입
	public int joinMember(Member join_info) {
		return androidMapper.joinMember(join_info);
	}
	
	// 로그인
	public Member login(Member login_info) {
		return androidMapper.login(login_info);
	}
}
