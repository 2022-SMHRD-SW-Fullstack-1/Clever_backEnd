package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeAttendance {

	int ch_seq;
	int att_seq;
	String ch_approve;
	String ch_reject_memo;
	String mem_id;
	String ch_start_time;
	String ch_end_time;
	String ch_date;
	int group_seq;
	
}
