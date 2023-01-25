package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Notice;
import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;


@Mapper
public interface ToDoMapper {
	
	// 할일 등록
	@Insert("insert into tbl_todo values(null, #{cate_seq}, #{todo_title}, #{todo_content},  localtimestamp, #{todo_repeat}, '', #{todo_method})")
	public int toDoCreate(ToDo toDoCreate);
	
	// 카테고리 불러오기
	@Select("select * from tbl_category where cate_type='ToDo' and group_seq='3'")
	public List<Category> getCategory();
	
	// 담당자 불러오기
	@Select ("select tm.mem_name from tbl_member tm inner join tbl_join tj on tm.mem_id = tj.mem_id where tj.group_seq='3' ")
	public List<Group> getMember();
	
	// 할 일 불러오기
	@Select("select * from tbl_todo")
	public List<ToDo> toDoList(ToDo toDoList);
	
	// 할 일 수정
	@Select("select * from tbl_todo where todo_seq = #{todo_seq}")
	public ToDo editTodo(ToDo todo_seq);
	
	//완료된 할 일 상세보기
	@Select("select * from tbl_complete where todo_seq=#{todo_seq}")
	public List<ToDoComplete> toDoDetail(ToDo toDoDetail);
	
	// 공지사항 불러오기
	@Select ("select notice_content from tbl_notice where notice_dt ='2023-01-25' ")
	public List<Notice> todayNotice(Notice todayNotice);
}
