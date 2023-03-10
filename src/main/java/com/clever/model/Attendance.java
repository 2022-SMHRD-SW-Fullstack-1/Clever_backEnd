package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

	int att_seq;
	String mem_id;
	String att_date;
	String att_sche_start_time;
	String att_sche_end_time;
	String att_real_start_time;
	String att_real_end_time;	
	String mem_name;
	int group_seq;
	int late_time;
	int total_work_time;
}