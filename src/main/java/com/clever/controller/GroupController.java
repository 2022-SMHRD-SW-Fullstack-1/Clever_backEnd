package com.clever.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Group;
import com.clever.service.GroupService;

@RestController
public class GroupController {
	@Autowired
	GroupService groupService;
	
	@PostMapping("/addgroup")
	public int addGroup(@RequestBody Group group_info) {
		
		return groupService.addGroup(group_info);
	}
		
}

