package com.clever.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.ToDoComplete;
import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Join;
import com.clever.model.Member;
import com.clever.model.Notice;

import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;
import com.clever.service.ToDoService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/todolist")
@RestController
public class ToDoController {

	private final ToDoService toDoService;
	
	// 할일 등록
	@PostMapping("/addtodo")
	public int toDoCreate(@RequestBody ToDo toDoCreate) {
		return toDoService.toDoCreate(toDoCreate);
	}
	
	// 카테고리 추가
	@PostMapping("/addcategory")
	public int addToDoCate(@RequestBody ToDo addToDoCate) {
		return toDoService.addToDoCate(addToDoCate);
	}
	
	// 할일 카테고리 불러오기
	@PostMapping("/getcategory")
	public List<Category> getCategory (@RequestBody Category cate_info) {
		List <Category> cateList = toDoService.getCategory(cate_info.getGroup_seq());
		return cateList;
	}
	
	// 그룹 정보 불러오기
	@PostMapping("/getgroup")
	public List<Group> getGroupInfo(@RequestBody Group group_info){
		List <Group> groupList = toDoService.getGroupInfo(group_info.getGroup_seq());
		return groupList;
	}
	
	// 담당자 목록 불러오기
	@PostMapping("/getmember")
	public List<Member> getMember(@RequestBody Group group_info){
		List <Member> memList = toDoService.getMember(group_info.getGroup_seq());
		return memList;
	}
	
	// 할일 전체 불러오기
	@PostMapping("/alltodo")
	public List<ToDo> getAllToDo(@RequestBody ToDo todo_info){
		List<ToDo> allToDoList = toDoService.getAllToDo(todo_info.getGroup_seq());
		return allToDoList;
	}

	// 할일 불러오기
//	@PostMapping("/todolist")
//	public List<ToDo> getToDoList(@RequestBody ToDo todo_info){
//		List<ToDo> todoList = toDoService.toDoList(todo_info.getCate_seq());
//		return todoList;
//	}
	@PostMapping("/todolist")
	public void getToDoList(@RequestBody ToDo todo_info){
		System.out.println(todo_info);
	}
	

	// 할 일 수정
	@PostMapping("/edit")
	public ToDo editTodo(@RequestBody ToDo todo_info)  {
		return toDoService.editTodo(todo_info);
	}
	
	 // 할 일 삭제
    @PostMapping("/delete")
    public int toDoDelete (@RequestBody ToDo todo_info) {
    	return toDoService.toDoDelete(todo_info.getTodo_seq());
    }
	
	
	// 완료된 할 일
    @PostMapping("/todocom")
		public List<ToDoComplete> toDoDetail (@RequestBody ToDo toDoDetail){
			return toDoService.toDoDetail(toDoDetail);

		}
    
    // 오늘의 특이사항
    @PostMapping("/todaymemo")
    public List<ToDoComplete> todayMemo (ToDoComplete todayMemo){
    	return toDoService.todayMemo(todayMemo);
    }
    
   

}
