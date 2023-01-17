package com.clever.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.GroupMapper;
import com.clever.model.Group;

@Service
public class GroupService {
	@Autowired
	GroupMapper groupMapper;
	public int addGroup(Group group_info) {
		group_info.setGroup_serial(serialNum());
		return groupMapper.addGroup(group_info);
	}
	
	public List<Group> getGroupList(String mem_id){
		return groupMapper.getGroupList(mem_id);
	}
	
	public String serialNum() {
		
		int serialSize = 1;
		final char[] possibleChar = {
				'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
			     'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
			     'W','X','Y','Z'
		};
		final int possibleCharCnt = possibleChar.length;
		String[] arr = new String[serialSize];
		Random rd = new Random();
		int currentIndex = 0;
		int i = 0;
		StringBuffer buf = new StringBuffer(16);
		for(i=8 ; i>0 ; i--) {
			buf.append(possibleChar[rd.nextInt(possibleCharCnt)]);
		}
		String group_serial = buf.toString();
		return group_serial;
}
}
