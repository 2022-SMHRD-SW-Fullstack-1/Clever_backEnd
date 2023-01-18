package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Category;
import com.clever.model.ToDo;


@Mapper
public interface ToDoMapper {
	
	// 할일 등록
	@Insert("insert into tbl_todo values(null, #{cate_seq}, #{todo_title}, #{todo_content},  localtimestamp, #{todo_repeat}, '', #{todo_method})")
	public int toDoCreate(ToDo toDoCreate);
	
	// 카테고리 불러오기
	@Select("select * from tbl_category where cate_type='ToDo'")
	public List<Category> getCategory();
	
	// 할 일 불러오기
	@Select("select * from tbl_todo")
	public List<ToDo> toDoList(ToDo toDoList);
}
