package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.clever.model.Category;
import com.clever.model.Notice;
import com.clever.model.NoticeComment;

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
	
	@Select("select notice_seq, cate_seq, notice_title, notice_content, notice_dt, notice_photo, tm.mem_id, tm.mem_name from tbl_notice tn inner join tbl_member tm on tn.mem_id = tm.mem_id WHERE cate_seq = #{cate_seq} order by notice_seq desc")
	public List<Notice> getBoardList(int cate_seq);
	
	@Delete("delete from tbl_notice where notice_seq = #{notice_seq}")
	public int deleteBoard(Notice notice_info);
	
	@Update("update tbl_notice set notice_title = #{notice_title}, notice_content =#{notice_content}, notice_dt = now(), notice_photo = #{notice_photo} where notice_seq = #{notice_seq}")
	public int updateBoard(Notice notice_info);
	
	@Insert("insert into tbl_notice_comment values(null, #{notice_seq}, #{mem_id}, #{com_content}, now())")
	public int postBoardComment(NoticeComment notice_info);
}
