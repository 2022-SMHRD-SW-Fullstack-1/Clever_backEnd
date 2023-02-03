package com.clever.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.ToDoMapper;
import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Join;
import com.clever.model.Member;
import com.clever.model.Notice;

import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;


@Service
public class ToDoService {
	
	@Autowired
	ToDoMapper toDoMapper;
	
	// 할 일 등록
	public int toDoCreate(ToDo toDoCreate) {
		if(toDoCreate.getMem_id().equals("")) {
			toDoCreate.setMem_id(null);
		}
		return toDoMapper.toDoCreate(toDoCreate);
	}
	
	// 카테고리 추가
	public int addToDoCate (ToDo addToDoCate) {
		return toDoMapper.addToDoCate(addToDoCate);
	}
	
	// 카테고리 가져오기
	public List<Category> getCategory(int group_seq) {
		return toDoMapper.getCategory(group_seq);
	}


	// 그룹 정보 불러오기
	public List<Group> getGroupInfo(int group_seq){
		return toDoMapper.getGroupInfo(group_seq);
	}


	// 담당자 불러오기
	public List<Member> getMember(int group_seq){
		return toDoMapper.getMember(group_seq);
	}

	
	// 할일 가져오기
	public List<ToDo> toDoList(int cate_seq){
		return toDoMapper.toDoList(cate_seq);
	}
	
	// 할일 수정
	public ToDo editTodo(ToDo todo_info){
		return toDoMapper.editTodo(todo_info);
	}
	
	// 할일 삭제
	public int toDoDelete(int todo_seq) {
		return toDoMapper.toDoDelete(todo_seq);
	}
	
	// 오늘의 특이사항
	public List<ToDoComplete> todayMemo (ToDoComplete todayMemo){
		return toDoMapper.todayMemo(todayMemo);
	}
	
	// 완료된 할 일
	public List<ToDoComplete> toDoDetail(ToDo toDoDetail){
		return toDoMapper.toDoDetail(toDoDetail);

	}
	
	

}
