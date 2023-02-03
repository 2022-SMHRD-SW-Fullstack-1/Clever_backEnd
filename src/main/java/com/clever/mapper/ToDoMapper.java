package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	// 그룹 정보 불러 오기
	@Select("select * from tbl_group tg inner join tbl_join tj on tg.group_seq = tj.group_seq where #{mem_id} = tj.mem_id")
	public List<Group> getGroupInfo(int group_seq); 
	
	// 카테고리 추가
	@Insert("insert into tbl_category values(null, 'ToDo', #{cate_name}, #{group_seq} )")
	public int addToDoCate(ToDo addToDoCate);
	
	// 카테고리 불러 오기
	@Select("select * from tbl_category where group_seq = #{group_seq} and (cate_type='ToDo' or cate_type='Default')")
	public List<Category> getCategory(int group_seq);
	
	// 담당자 불러 오기
	@Select ("select tm.mem_id, tm.mem_name from tbl_member tm inner join tbl_join tj on tm.mem_id = tj.mem_id where tj.group_seq=#{group_seq} ")
	public List<Member> getMember(int group_seq);
	
	// 할 일 불러 오기
	@Select("select * from tbl_todo where cate_seq = #{cate_seq} ")
	public List<ToDo> toDoList(int cate_seq);
	
	// 할 일 수정
	@Update("update tbl_todo set todo_seq = #{todo_seq}, cate_seq = #{cate_seq}, todo_title = #{todo_title}, todo_content = #{todo_content}, todo_dt = localtimestamp, todo_repeat = #{todo_repeat}, mem_id = #{mem_id}, todo_method = #{todo_method}")
	public ToDo editTodo(ToDo todo_info);
	
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


