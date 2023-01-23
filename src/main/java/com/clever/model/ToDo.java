package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

	int todo_seq;
	int cate_seq;
	String todo_title;
	String todo_content;
	String todo_dt;
	String todo_repeat;
	String todo_method;
	String mem_id;
	String mem_name;
	String cate_name;

}
