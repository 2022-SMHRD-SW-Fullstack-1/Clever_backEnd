package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Category;
import com.clever.model.Notice;

@Mapper
public interface BoardMapper {
	
	@Insert("insert into tbl_category values(null, 'Notice' , #{cate_name}, #{group_seq})")
	public int addBoardCategory(Category cate_info);
	
	@Select("select count(*) from tbl_category where group_seq=#{group_seq}")
	public int countBoardCategory(Category cate_info);
	
	@Select("select cate_seq, cate_name, group_seq from tbl_category where cate_type='Notice' and group_seq=#{group_seq}")
	public List<Category> getBoardCategory(int group_seq);
	
	@Insert("insert into tbl_notice values(null, #{cate_seq}, #{notice_title}, #{notice_content}, now(), #{notice_photo}, #{mem_id})")
	public int postBoard(Notice notice_info);
	
	@Select("select notice_seq, notice_title, notice_content, notice_dt, notice_photo, mem_id from tbl_notice WHERE cate_seq = #{cate_seq}")
	public List<Notice> getBoardList(int cate_seq);

}
