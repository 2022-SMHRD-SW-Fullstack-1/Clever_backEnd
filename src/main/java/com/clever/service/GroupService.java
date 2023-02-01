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
	
	public int joinManager(Group group_info) {
		return groupMapper.joinManager(group_info);
	}
	
	public List<Group> getGroupList(String mem_id){
		return groupMapper.getGroupList(mem_id);
	}
	
	public int deleteGroup(Group group_info) {
		return groupMapper.deleteGroup(group_info);
	}
	
	public String getInviteCode(int group_seq) {
		return groupMapper.getInviteCode(group_seq);
	}
	
	public int editGroupName(Group group_info) {
		return groupMapper.editGroupName(group_info);
	}
	
	public String serialNum() {
		
		StringBuffer key = new StringBuffer();
		Random rd = new Random();
		
		for(int i=0; i<8; i++) { // 인증코드 8자리
			int index = rd.nextInt(3); // 0~2까지 랜덤, rd값에 따라 아래 switch 문이 실행됨
			
			switch (index) {
				case 0:
					key.append((char) ((int) (rd.nextInt(26)) + 97)); // 영어 소문자
					// a~z ( ASCII 코드 : ex. (char)98='b' )
					break;
				case 1:
					key.append((char) ((int) (rd.nextInt(26)) + 65)); // 영어 대문자
					break;
				case 2:
					key.append((rd.nextInt(10))); // 숫자
					break;	
			}
		}
		String group_serial = key.toString();
		return group_serial;
}
	

}
