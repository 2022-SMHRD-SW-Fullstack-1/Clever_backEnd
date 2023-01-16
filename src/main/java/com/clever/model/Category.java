package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	int cate_seq;
	String cate_type;
	String cate_name;
	int group_seq;
	int count;
	
}
