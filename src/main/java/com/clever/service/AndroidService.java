package com.clever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.controller.EmailController;
import com.clever.mapper.AndroidMapper;
import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Member;
import com.clever.model.Notice;
import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;

@Service
public class AndroidService {
	
	@Autowired
	AndroidMapper androidMapper;
	
	@Autowired
	EmailService emailService;

	// 회원가입
	public int joinMember(Member join_info) {
		return androidMapper.joinMember(join_info);
	}
	
	// 로그인
	public Member login(Member login_info) {
		return androidMapper.login(login_info);
	}
	
	// mainActivity groupList 가져오기
	public List<Group> getGroup(String mem_id){
		return androidMapper.getGroup(mem_id);
	}
	
	public Group groupInfo(int group_seq) {
		return androidMapper.groupInfo(group_seq);
	}
	
	public Group joinDate(Group group_info) {
		return androidMapper.joinDate(group_info);
	}
	
	public Member userInfo(String mem_id) {
		return androidMapper.userInfo(mem_id);
	}
	
	public List<Group> groupMem(int group_seq){
		return androidMapper.groupMem(group_seq);
	}
	
	public List<Category> getCategory(Category category){	
		return androidMapper.getCategory(category);	
	}
	
	public List<Notice> getNotice(Notice notice){
		return androidMapper.getNotice(notice);
	}
	
	public Notice getNoticeDetail(Notice notice) {
		return androidMapper.getNoticeDetail(notice);
	}
	
	public List<ToDo> getToDoList(int cate_seq) {
		return androidMapper.getToDoList(cate_seq);
	}
	
	public List<ToDoComplete> getToDoComplete(int cate_seq){
		
		List<ToDoComplete> getTodo = androidMapper.getToDoComplete(cate_seq);
		
		for(int i=0; i<getTodo.size(); i++) {
			int todo_seq = getTodo.get(i).getTodo_seq();
			String title = androidMapper.getTodoTitle(todo_seq);
			getTodo.get(i).setTodo_title(title);
		}
		return getTodo;
	}
	
	public ToDo getToDo(ToDo todo_info) {
		return androidMapper.getToDo(todo_info);
	}
	
	public List<ToDoComplete> getToDoCmplList(int todo_seq){
		return androidMapper.getToDoCmplList(todo_seq);
	}
	
	public String getCode(Member mem_info) throws Exception {
		Member result = androidMapper.getCode(mem_info);
		
		if(result != null) {
			
			String code = emailService.sendSimpleMessage(result.getMem_email());
			System.out.println("코드 : " + code);
			
			return code;
		}else {
			return "1";
		}
	}
	
	
	
}
