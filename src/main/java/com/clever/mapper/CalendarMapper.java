package com.clever.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.clever.model.CalendarInput;

@Mapper
public interface CalendarMapper {
	
	
	//(att_seq, mem_id, att_type, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq )	
	@Insert("insert into tbl_attendance values(null, 001, A, #{att_date}, #{att_sche_start_time}, #{att_sche_end_time}, null, null, null)")
	int addSchedule(CalendarInput addInfo );

}
