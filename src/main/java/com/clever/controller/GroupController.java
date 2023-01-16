package com.clever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Group;
import com.clever.service.GroupService;

@RestController
public class GroupController {
	@Autowired
	GroupService groupService;
	public int addGroup(@RequestBody Group group_info) {
		return groupService.addGroup(group_info);
	}
}
