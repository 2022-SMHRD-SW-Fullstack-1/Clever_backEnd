package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

	int group_seq;
	String group_name;
	String group_dt;
	String group_serial;
	String mem_id;
	String join_dt;
	String mem_name;
	
}
