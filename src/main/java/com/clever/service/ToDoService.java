package com.clever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.ToDoMapper;
import com.clever.model.Category;
import com.clever.model.ToDo;


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
	
	// 할 일 가져오기
	public List<ToDo> toDoList(ToDo toDoList){
		return toDoMapper.toDoList(toDoList);
	}
	

}
