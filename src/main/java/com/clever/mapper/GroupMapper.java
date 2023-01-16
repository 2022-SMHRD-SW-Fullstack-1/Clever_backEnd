package com.clever.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.clever.model.Group;

@Mapper
public interface GroupMapper {
	// 그룹 추가
	@Insert("insert into tbl_group values(null, #{group_name), #{group_serial}, now(), #{mem_id}")
	public int addGroup(Group group_info);
}
