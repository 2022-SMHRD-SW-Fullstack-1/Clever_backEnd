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
		group_info.setGroup_serial(serialNum());
		return groupService.addGroup(group_info);
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

