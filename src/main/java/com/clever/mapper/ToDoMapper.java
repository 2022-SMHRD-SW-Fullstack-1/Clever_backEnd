package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Join;
import com.clever.model.Member;
import com.clever.model.Notice;

import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;


@Mapper
public interface ToDoMapper {
	
	// 할일 등록
	@Insert("insert into tbl_todo values(null, #{cate_seq}, #{todo_title}, #{todo_content}, localtimestamp, #{todo_repeat}, #{mem_id}, #{todo_method})")
	public int toDoCreate(ToDo toDoCreate);
	
	// 그룹 정보 불러오기
	@Select("select * from tbl_group tg inner join tbl_join tj on tg.group_seq = tj.group_seq where #{mem_id} = tj.mem_id")
	public List<Group> getGroupInfo(int group_seq); 
	
	// 카테고리 추가
	@Insert("insert into tbl_category values(null, 'ToDo', #{cate_name}, #{group_seq} )")
	public int addToDoCate(ToDo addToDoCate);
	
	// 카테고리 불러오기
	@Select("select * from tbl_category where (cate_type='ToDo' and group_seq = #{group_seq}) or cate_type='Default'")
	public List<Category> getCategory(int group_seq);
	
	// 담당자 불러오기
	@Select ("select tm.mem_id, tm.mem_name from tbl_member tm inner join tbl_join tj on tm.mem_id = tj.mem_id where tj.group_seq=#{group_seq} ")
	public List<Group> getMember();
	
	// 할 일 불러오기
	@Select("select * from tbl_todo where cate_seq = #{cate_seq} ")
	public List<ToDo> toDoList(int cate_seq);
	
	// 할 일 수정
	@Select("select * from tbl_todo where todo_seq = #{todo_seq}")
	public ToDo editTodo(ToDo todo_seq);
	
	// 할 일 삭제
	@Delete("delete from tbl_todo where todo_seq = #{todo_seq}")
	public int toDoDelete(int todo_seq);
	
	//완료된 할 일 상세보기
	@Select("select * from tbl_complete tc inner join tbl_member tm on tc.mem_id = tm.mem_id where cate_seq = #{cate_seq} ")
	public List<ToDoComplete> toDoDetail(ToDo toDoDetail);
	
	// 일일 특이사항 불러오기
	@Select ("select cmpl_memo from tbl_complete where DATE_FORMAT(cmpl_time, '%Y-%m-%d')  = DATE_FORMAT(NOW(), '%Y-%m-%d')")
	public List<ToDoComplete> todayMemo(ToDoComplete todayMemo);


}


