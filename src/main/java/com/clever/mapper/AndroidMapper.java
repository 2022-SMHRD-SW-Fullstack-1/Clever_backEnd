package com.clever.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Member;

@Mapper
public interface AndroidMapper {
	
	// 회원가입
	@Insert("INSERT INTO tbl_member VALUES (#{mem_id}, #{mem_pw}, #{mem_name}, #{mem_email}, now(), 'N')")
	public int joinMember(Member join_info);
	
	// 로그인
	@Select("SELECT * FROM tbl_member WHERE mem_id=#{mem_id} AND mem_pw=#{mem_pw}")
	public Member login(Member login_info);

}
