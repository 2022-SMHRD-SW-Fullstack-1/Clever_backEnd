package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.clever.model.Group;

@Mapper
public interface GroupMapper {
	// 그룹 추가
	public int addGroup(Group group_info);
	
	// 그룹 추가 후 관리자 가입
	public int joinManager(Group group_info);
	
	// 그룹 목록 불러오기
	@Select("select group_seq, group_name, group_dt from tbl_group where mem_id=#{mem_id}")
	public List<Group> getGroupList(String mem_id);
	
	// 그룹 삭제
	@Delete("delete from tbl_group where mem_id=#{mem_id} and group_seq=#{group_seq}")
	public int deleteGroup(Group group_info);
	
	// 초대 코드(시리얼번호)
	@Select("select group_serial from tbl_group where group_seq=#{grouq_seq}")
	public String getInviteCode(int grouq_seq);
	
	@Update("update tbl_group set group_name = #{group_name} where group_seq = #{group_seq}")
	public int editGroupName(Group group_info);
}
