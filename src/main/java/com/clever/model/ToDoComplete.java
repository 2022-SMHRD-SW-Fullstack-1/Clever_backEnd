package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoComplete {

	int cmpl_seq;
	int todo_seq;
	String mem_id;
	String cmpl_time;
	String cmpl_img;
	String cmpl_memo;
	String cmpl_strange;
	int cate_seq;
	String todo_title;
	String mem_name;
	
}
