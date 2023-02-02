package com.clever.mapper;



import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.clever.model.Attendance;
import com.clever.model.ChangeAttendance;
import com.clever.model.Join;

@Mapper
public interface CalendarMapper {
	
	
	//(att_seq, mem_id, att_type, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq )	
	
	
	@Select("SELECT TIMESTAMPDIFF(minute,ta.att_real_start_time, ta.att_real_end_time) as total_work_time, TIMESTAMPDIFF(minute,ta.att_sche_start_time, ta.att_real_start_time) as late_time,ta.mem_id, ta.att_seq ,ta.att_real_start_time, ta.att_real_end_time, tm.mem_name, ta.att_date ,att_sche_start_time ,att_sche_end_time,group_seq FROM tbl_attendance ta INNER JOIN tbl_member tm on ta.mem_id = tm.mem_id where group_seq=#{groupSeq}" )
	List<Attendance> getSchedule(int groupSeq);
	
	
	@Delete("DELETE from tbl_attendance WHERE att_date=#{att_date} and group_seq = #{group_seq} ")
	int deleteSchedul(Attendance date);
	
//	@Insert("insert into tbl_attendance (att_seq, mem_id, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq) values(null, ((SELECT mem_id from tbl_member  where mem_name = #{mem_name})), #{att_date}, #{att_sche_start_time},#{att_sche_end_time},null, null, #{group_seq})")
//	int insertSchedule(Attendance sendInfo);
	
	
//	@Insert("insert into tbl_attendance (att_seq, mem_id, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq) values(null, ((SELECT mem_id from tbl_member  where mem_name = #{mem_name})), #{att_date}, #{att_sche_start_time},#{att_sche_end_time},null, null, #{group_seq})")
//	int updateSchedul(Attendance updateInfo);
	@Insert("insert into tbl_attendance (att_seq, mem_id, att_date, att_sche_start_time, att_sche_end_time, att_real_start_time, att_real_end_time, group_seq) values(null, #{mem_id}, #{att_date}, #{att_sche_start_time},#{att_sche_end_time},null, null, #{group_seq})")
	int insertSchedule(Attendance sendInfo);
	
	@Insert("insert into tbl_attendance values (null, #{mem_id}, #{att_date}, #{att_sche_start_time},#{att_sche_end_time},null, null, #{group_seq})")
	int updateSchedul(Attendance updateInfo);
	
	@Select("select tca.att_seq, tca.ch_seq, tca.ch_approve, tca.ch_reject_memo ,tm.mem_name  ,tca.mem_id,  tca.ch_start_time ,tca.ch_end_time ,tca.ch_date ,tca.group_seq from tbl_change_attendance tca inner join tbl_member tm  on   tca.mem_id =tm.mem_id and group_seq=#{groupSeq}")
	List<ChangeAttendance>getModification(int groupSeq);
	
	@Update("update tbl_change_attendance set ch_approve =#{ch_approve} where ch_seq=#{ch_seq}")
	int confirmModification(ChangeAttendance confirmModification);
	
	@Update("update tbl_change_attendance set ch_approve =#{ch_approve}, ch_reject_memo=#{ch_reject_memo} where ch_seq=#{ch_seq}")
	int rejectModification(ChangeAttendance rejectModification);
	
	@Update("update tbl_attendance set att_sche_start_time=#{ch_start_time}, att_sche_end_time=#{ch_end_time} where att_seq=#{att_seq}")
	int updateModifiCation(ChangeAttendance updateModification);
	
	@Select("SELECT tj.join_seq , tj.group_seq , tj.mem_id, tj.join_dt, tj.cate_seq , tm.mem_name FROM tbl_join tj  INNER JOIN tbl_member tm ON tj.mem_id = tm.mem_id and group_seq=#{group_seq}")
	List<Join> getWorkerList(int groupSeq);
	
	
//(SELECT mem_id from tbl_member  where mem_name = #{mem_name})
}