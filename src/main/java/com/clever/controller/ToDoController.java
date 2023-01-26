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
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.ToDoComplete;
import com.clever.model.Category;
import com.clever.model.Group;
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
	
	Gson gson = new Gson();

	
	private final ToDoService toDoService;
	
	// 할 일 등록
	@PostMapping("/addtodo")
	public int toDoCreate(@RequestBody ToDo toDoCreate) {
		System.out.println("addtodo : " +toDoCreate);
		return toDoService.toDoCreate(toDoCreate);
	}
	
	// 할 일 카테고리 불러오기
	@PostMapping("/getcategory")
	public List<Category> getCategory() {
		return toDoService.getCategory();
	}
	
	// 담당자 불러오기
	@PostMapping("/getmember")
	public List<Group> getMember(){
		return toDoService.getMember();
	}

	// 할 일 불러오기
	@PostMapping("/todolist")
	public List<ToDo> toDoList(ToDo toDoList){
		return toDoService.toDoList(toDoList);
	}
	

	// 클릭한 할 일 수정
	@PostMapping("/edittodo")
	public String editTodo(@RequestBody ToDo todo_seq) {
		System.out.println("넘어오는 값" + todo_seq);
		
		Map<String, Object> result = (toDoService.editTodo(todo_seq));
		System.out.println(result);
//		System.out.println("detailPro Service");
//		result.put("commentView", qnaService.commentView(pro_Num));
//		System.out.println("commentView Service");
//		System.out.println("넘겨주는 comments값 : " + result);
		
		return gson.toJson(result);
	}
	
	// 완료된 할 일
    @PostMapping("/tododetail")
		public void toDoDetail (ToDo toDoDetail){
    	System.out.println("넘어온 값 : "+ toDoDetail);
//			return toDoService.toDoDetail(toDoDetail);
		}
    
    // 오늘의 특이사항
    @PostMapping("/todaynotice")
    public List<Notice> todayNotice (Notice todayNotice){
    	return toDoService.todayNotice(todayNotice);
    }

}
