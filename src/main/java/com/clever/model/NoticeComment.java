package com.clever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeComment {

    int com_seq;
    int notice_seq;
    String mem_id;
    String mem_name;
    String com_content;
    String com_time;

}
