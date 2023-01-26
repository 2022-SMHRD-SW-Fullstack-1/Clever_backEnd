package com.clever.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.ToDoMapper;
import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Notice;

import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;


@Service
public class ToDoService {
	
	@Autowired
	ToDoMapper toDoMapper;
	
	// 할 일 등록
	public int toDoCreate(ToDo toDoCreate) {
		return toDoMapper.toDoCreate(toDoCreate);
	}
	
	// 카테고리 가져오기
	public List<Category> getCategory() {
		return toDoMapper.getCategory();
	}
	


	// 담당자 불러오기
	public List<Group> getMember(){
		return toDoMapper.getMember();
	

	}
	
	// 할 일 가져오기
	public List<ToDo> toDoList(ToDo toDoList){
		return toDoMapper.toDoList(toDoList);
	}
	

	// 할 일 수정
	public HashMap<String, Object> editTodo(ToDo todo_seq){
		ToDo todo = toDoMapper.editTodo(todo_seq);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("todo_seq", todo.getTodo_seq());
		result.put("cate_seq", todo.getCate_seq());
		result.put("todo_title)", todo.getTodo_title());
		result.put("todo_content", todo.getTodo_content());
		result.put("todo_dt", todo.getTodo_dt());
		result.put("todo_repeat", todo.getTodo_repeat());
		result.put("mem_id", todo.getMem_id());
		result.put("todo_method", todo.getTodo_repeat());

		return result;
	}
	

	
	// 오늘의 특이사항
	public List<Notice> todayNotice (Notice todayNotice){
		return toDoMapper.todayNotice(todayNotice);
	}
	
	// 완료된 할 일
	public List<ToDoComplete> toDoDetail(ToDo toDoDetail){
		return toDoMapper.toDoDetail(toDoDetail);

	}

}
