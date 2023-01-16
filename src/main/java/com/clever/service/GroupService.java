package com.clever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.GroupMapper;
import com.clever.model.Group;

@Service
public class GroupService {
	@Autowired
	GroupMapper groupMapper;
	public int addGroup(Group group_info) {
		return groupMapper.addGroup(group_info);
	}
}
