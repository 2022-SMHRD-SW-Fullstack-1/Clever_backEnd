package com.clever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Category;
import com.clever.model.ToDo;
import com.clever.service.ToDoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/todolist")
@RestController
public class ToDoController {

	
	private final ToDoService toDoService;
	
	// 할 일 등록
	@PostMapping("/addtodo")
	public int toDoCreate(@RequestBody ToDo toDoCreate) {
		return toDoService.toDoCreate(toDoCreate);
	}
	
	// 할 일 카테고리 불러오기
	@PostMapping("/getcategory")
	public List<Category> getCategory() {
		return toDoService.getCategory();
	}
	
	// 담당자 불러오기
//	@PostMapping("/getmember")
//	public List<Join> getMember(){
//		return toDoService.getMember();
//	}
//	
	// 할 일 불러오기
	@PostMapping("/todolist")
	public List<ToDo> toDoList(ToDo toDoList){
		return toDoService.toDoList(toDoList);
	}

}
