package com.clever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.MemberMapper;
import com.clever.model.Join;
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
	
	public List<Join> getGroupMemList(Join group_info) {
		return memberMapper.getGroupMemList(group_info);
	}
	
	public int deleteGroupMem(Join join_info) {
		return memberMapper.deleteGroupMem(join_info);
	}
	

}
