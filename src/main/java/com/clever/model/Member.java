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
}


