package com.clever.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clever.model.CalendarInput;

@Mapper
public interface CalendarMapper {
	
	
	//(att_seq, mem_id, att_type, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq )	
	@Insert("insert into tbl_attendance values(null, #{mem_id}, #{att_date}, #{att_sche_start_time},#{att_sche_end_time}, null, null, null)")
	int insertSchedule(CalendarInput sendInfo);
	
	@Select("SELECT tm.mem_name, ta.att_date ,att_sche_start_time ,att_sche_end_time FROM tbl_attendance ta INNER JOIN tbl_member tm ON ta.mem_id = tm.mem_id" )
	List<CalendarInput> getSchedule();

}


