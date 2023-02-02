package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Join;
import com.clever.model.Member;

@Mapper
public interface MemberMapper {
	
	// 회원가입
	@Insert("insert into tbl_member values(#{mem_id}, #{mem_pw},#{mem_name}, #{mem_email}, NOW(), 'N')")
	public int joinMember(Member join_info);
	
	// 로그인
	@Select("select * from tbl_member where mem_id=#{mem_id} and mem_pw=#{mem_pw}")
	public Member loginMember(Member login_info);
	
	@Select("select * from tbl_join j inner join tbl_member m on j.mem_id = m.mem_id where group_seq = #{group_seq}")
	public List<Join> getGroupMemList(Join group_info);
	
	@Delete("delete from tbl_join where join_seq = #{join_seq}")
	public int deleteGroupMem(Join join_info);
}
