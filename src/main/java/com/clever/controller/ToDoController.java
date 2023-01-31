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
	
	// 카테고리 추가
	@PostMapping("/addcategory")
	public int addToDoCate(@RequestBody ToDo addToDoCate) {
		System.out.println("카테고리 : "+ addToDoCate);
		
		return toDoService.addToDoCate(addToDoCate);
	}
	
	// 할 일 카테고리 불러오기
	@PostMapping("/getcategory")
	public List<Category> getCategory (@RequestBody Category cate_info) {
//		return toDoService.getCategory();
		List <Category> cateList = toDoService.getCategory(cate_info.getGroup_seq());
//		System.out.println("넘어온 값:" + cate_info);
		return cateList;
	}
	
	// 그룹 정보 불러오기
	@PostMapping("/getgroup")
	public List<Group> getGroupInfo(@RequestBody Group group_info){
		List <Group> groupList = toDoService.getGroupInfo(group_info.getGroup_seq());
//		System.out.println("groupInfo" + group_info);
		return groupList;
	}
	
	// 담당자 목록 불러오기
	@PostMapping("/getmember")
	public List<Group> getMember(){
		return toDoService.getMember();
	}

	// 할 일 불러오기
	@PostMapping("/todolist")
	public List<ToDo> getToDoList(@RequestBody ToDo todo_info){
//		System.out.println("cateTodo : "+todo_info);
		List<ToDo> todoList = toDoService.toDoList(todo_info.getCate_seq());
		return todoList;
	}

	// 할 일 수정
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
	
	 // 할 일 삭제
    @PostMapping("/delete")
    public int toDoDelete (@RequestBody ToDo todo_info) {
    	return toDoService.toDoDelete(todo_info.getTodo_seq());
    }
	
	
	// 완료된 할 일
    @PostMapping("/tododetail")
		public List<ToDoComplete> toDoDetail (@RequestBody ToDo toDoDetail){
    	System.out.println("넘어온 값 : "+ toDoDetail);
			return toDoService.toDoDetail(toDoDetail);
		}
    
    // 오늘의 특이사항
    @PostMapping("/todaynotice")
    public List<Notice> todayNotice (Notice todayNotice){
    	return toDoService.todayNotice(todayNotice);
    }
    
   

}
