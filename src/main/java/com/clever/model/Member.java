package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String mem_id;
	String mem_pw;
	String mem_name;
	String mem_email;
	String mem_joindate;
	String mem_type;
	
	public Member(String mem_id, String mem_pw, String mem_name, String mem_email) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
	}
	
}


