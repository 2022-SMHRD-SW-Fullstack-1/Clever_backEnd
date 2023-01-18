package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Group;

@Mapper
public interface GroupMapper {
	// 그룹 추가
	@Insert("insert into tbl_group values(null, #{group_name}, #{group_serial}, now(), #{mem_id})")
	public int addGroup(Group group_info);
	
	// 그룹 목록 불러오기
	@Select("select group_seq, group_name from tbl_group where mem_id=#{mem_id}")
	public List<Group> getGroupList(String mem_id);
	
	// 그룹 삭제
	@Delete("delete from tbl_group where mem_id=#{mem_id} and group_seq=#{group_seq}")
	public int deleteGroup(Group group_info);
}
