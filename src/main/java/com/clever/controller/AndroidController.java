package com.clever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Member;
import com.clever.model.Notice;
import com.clever.service.AndroidService;

@RestController
public class AndroidController {
	
	@Autowired
	AndroidService androidService;

	@GetMapping("/android/hello")
	public String hello() {
		System.out.println("Hello Android");
		return "Hello Android";
	}
	
	// 회원가입
	@PostMapping("/android/joinMember")
	public int joinMember(@RequestBody Member join_info) {
		return androidService.joinMember(join_info);
	}
	
	// 로그인
	@PostMapping("/android/login")
	public Member login(@RequestBody Member login_info) {
		return androidService.login(login_info);
	}
	
	// mainActivity groupList 가져오기
	@PostMapping("/android/getGroup")
	public List<Group> getGroup(@RequestBody Member user_info){
		return androidService.getGroup(user_info.getMem_id());
	}
	
	@PostMapping("/android/groupInfo")
	public Group groupInfo(@RequestBody Group group_info) {
		return androidService.groupInfo(group_info.getGroup_seq());
	}
	
	@PostMapping("/android/joinDate")
	public Group joinDate(@RequestBody Group group_info) {
		return androidService.joinDate(group_info);
	}
	
	@PostMapping("/android/userInfo")
	public Member userInfo(@RequestBody Member user_info) {
		return androidService.userInfo(user_info.getMem_id());
	}
	
	@PostMapping("/android/groupMem")
	public List<Group> groupMem(@RequestBody Group group_info){
		return androidService.groupMem(group_info.getGroup_seq());
	}
	
	@PostMapping("/android/getCategory")
	public List<Category> getCategory(@RequestBody Category category){
		return androidService.getCategory(category);
	}
	
	@PostMapping("/android/getNotice")
	public List<Notice> getNotice(@RequestBody Notice notice){
		return androidService.getNotice(notice);
	}
	
	@PostMapping("android/getNoticeDetail")
	public Notice getNoticeDetail(@RequestBody Notice notice) {
		return androidService.getNoticeDetail(notice);
	}
	
	
	
	

}
