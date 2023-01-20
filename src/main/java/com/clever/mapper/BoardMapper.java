package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Category;

@Mapper
public interface BoardMapper {
	
	@Insert("insert into tbl_category values(null, 'Notice' , #{cate_name}, #{group_seq})")
	public int addBoardCategory(Category cate_info);
	
	@Select("select count(*) from tbl_category where group_seq=#{group_seq}")
	public int countBoardCategory(Category cate_info);
	
	@Select("select cate_seq, cate_name, group_seq from tbl_category where cate_type='Notice' and group_seq=#{group_seq}")
	public List<Category> getBoardCategory(int group_seq);

}
