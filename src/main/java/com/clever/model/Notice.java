package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

	int notice_seq;
	int cate_seq;
	String notice_title;
	String notice_content;
	String notice_dt;
	String notice_photo;
	int mem_id;
	String mem_name;
	int count;
	
}
