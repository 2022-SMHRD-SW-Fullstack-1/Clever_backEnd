package com.clever.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Group;
import com.clever.service.GroupService;
import java.util.List;

@RestController
public class GroupController {
	@Autowired
	GroupService groupService;
	
	@PostMapping("/addgroup")
	public int addGroup(@RequestBody Group group_info) {
		groupService.addGroup(group_info);
		int seq = group_info.getGroup_seq();
		return seq;
	}
	
	@PostMapping("/joinManager")
	public int joinManager(@RequestBody Group group_info){
		return groupService.joinManager(group_info);
	}
	
	@PostMapping("/getgrouplist")
	public List<Group> getGroupList(@RequestBody String mem_id) {
		mem_id= mem_id.replaceAll("=", "");
		List<Group> groupList = groupService.getGroupList(mem_id);
		return groupList;
	}
	
	@PostMapping("/deletegroup")
	public int deleteGroup(@RequestBody Group group_info) {
		 return groupService.deleteGroup(group_info);
	}


}

