package com.clever.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Member;

@Mapper
public interface MemberMapper {
	
	// 회원가입
	@Insert("insert into tbl_member values(#{mem_id}, #{mem_pw},#{mem_email}, #{mem_name}, NOW(), 'N')")
	public int joinMember(Member join_info);
	
	// 로그인
	@Select("select * from tbl_member where mem_id=#{mem_id} and mem_pw=#{mem_pw}")
	public Member loginMember(Member login_info);

}
