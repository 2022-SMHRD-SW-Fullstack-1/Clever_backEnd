package com.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.clever.model.Attendance;
import com.clever.model.Category;
import com.clever.model.Group;
import com.clever.model.Member;
import com.clever.model.Notice;
import com.clever.model.ToDo;
import com.clever.model.ToDoComplete;

@Mapper
public interface AndroidMapper {
	
	// 회원가입
	@Insert("INSERT INTO tbl_member VALUES (#{mem_id}, #{mem_pw}, #{mem_name}, #{mem_email}, now(), 'N')")
	public int joinMember(Member join_info);
	
	// 로그인
	@Select("SELECT * FROM tbl_member WHERE mem_id = #{mem_id} AND mem_pw = #{mem_pw}")
	public Member login(Member login_info);
	
	// mainActivity groupList 가져오기
	@Select("SELECT tg.group_seq, tg.group_name FROM tbl_group tg LEFT JOIN tbl_join tj ON tg.group_seq = tj.group_seq WHERE tj.mem_id = #{mem_id}")
	public List<Group> getGroup(String mem_id);
	
	@Select("SELECT * FROM tbl_group WHERE group_seq = #{group_seq}")
	public Group groupInfo(int group_seq);
	
	@Select("SELECT * FROM tbl_join WHERE mem_id = #{mem_id} AND group_seq= #{group_seq}")
	public Group joinDate(Group group_seq);
	
	@Select("SELECT * FROM tbl_member WHERE mem_id = #{mem_id}")
	public Member userInfo(String mem_id);
	
	@Select("SELECT tj.group_seq, tj.mem_id, tj.join_dt, tm.mem_name FROM tbl_join tj LEFT JOIN tbl_member tm ON tj.mem_id = tm.mem_id WHERE tj.group_seq = #{group_seq}")
	public List<Group> groupMem(int group_seq);
	
	@Select("SELECT * FROM tbl_category WHERE group_seq = #{group_seq} AND cate_type = #{cate_type}")
	public List<Category> getCategory(Category category);
	
	@Select("SELECT tn.notice_seq, tn.cate_seq, tn.notice_content, tn.notice_title, tn.notice_dt, tn.notice_photo, tm.mem_name FROM tbl_notice tn LEFT JOIN tbl_member tm ON tn.mem_id = tm.mem_id WHERE cate_seq = #{cate_seq}")
	public List<Notice> getNotice(Notice notice);
	
	@Select("SELECT tn.notice_seq, tn.cate_seq, tn.notice_content, tn.notice_title, tn.notice_dt, tn.notice_photo, tm.mem_id, tm.mem_name FROM tbl_notice tn LEFT JOIN tbl_member tm ON tn.mem_id = tm.mem_id WHERE notice_seq = #{notice_seq}")
	public Notice getNoticeDetail(Notice notice);
	
	@Select("SELECT * FROM tbl_todo tt LEFT JOIN tbl_member tm ON tt.mem_id = tm.mem_id WHERE cate_seq = #{cate_seq}")
	public List<ToDo> getToDoList(int cate_seq);
	
	@Select("SELECT * FROM tbl_complete tc LEFT JOIN tbl_member tm ON tc.mem_id = tm.mem_id WHERE cate_seq = #{cate_seq}")
	public List<ToDoComplete> getToDoComplete(int cate_seq);
	
	@Select("SELECT todo_title FROM tbl_todo WHERE todo_seq = #{todo_seq}")
	public String getTodoTitle(int todo_seq);
	
	@Select("SELECT * FROM tbl_todo td LEFT JOIN tbl_category tc ON td.cate_seq = tc.cate_seq WHERE todo_seq = #{todo_seq}")
	public ToDo getToDo(ToDo todo_info);
	
	@Select("SELECT * FROM tbl_complete tc LEFT JOIN tbl_member tm ON tc.mem_id = tm.mem_id WHERE todo_seq = #{todo_seq}")
	public List<ToDoComplete> getToDoCmplList(int todo_seq);
	
	@Select("SELECT * FROM tbl_member WHERE mem_id = #{mem_id} AND mem_email = #{mem_email}")
	public Member getCode(Member mem_info);
	
	@Update("UPDATE tbl_member SET mem_pw = #{mem_pw} WHERE mem_id = #{mem_id}")
	public int changePw(Member mem_info);
	
	@Delete("DELETE tbl_group ")
	public int groupOut(Group group_info);
	
	@Insert("INSERT INTO tbl_complete VALUES (null, #{todo_seq}, #{mem_id}, now(), #{cmpl_img}, #{cmpl_memo}, #{cmpl_strange}, #{cate_seq})")
	public int todoCmpl(ToDoComplete cmpl_info);
	
	@Select("SELECT * FROM tbl_attendance WHERE mem_id = #{mem_id} AND group_seq = #{group_seq}")
	public List<Attendance> getAttendance(Attendance att_info);
	
	

}
