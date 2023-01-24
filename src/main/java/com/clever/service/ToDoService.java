package com.clever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.ToDoMapper;
import com.clever.model.Category;
import com.clever.model.Group;
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
	
	// 완료된 할 일
	public List<ToDoComplete> toDoDetail(ToDo toDoDetail){
		return toDoMapper.toDoDetail(toDoDetail);
	}

}
