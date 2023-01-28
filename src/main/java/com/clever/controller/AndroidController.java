package com.clever.controller;

import java.util.List;

import com.clever.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clever.service.AndroidService;

@RestController
public class AndroidController {

    @Autowired
    AndroidService androidService;

    @GetMapping("/android/hello")
    public String hello() {
        System.out.println("Hello Android");
        return "Hello Android";
    }

    // member
    @PostMapping("/android/joinMember")
    public int joinMember(@RequestBody Member join_info) {
        return androidService.joinMember(join_info);
    }

    @PostMapping("/android/login")
    public Member login(@RequestBody Member login_info) {
        return androidService.login(login_info);
    }

    @PostMapping("/android/chName")
    public int chName(@RequestBody Member mem_info) {
        return androidService.chName(mem_info);
    }

    @PostMapping("/android/changePw")
    public int changePw(@RequestBody Member mem_info) {
        return androidService.changePw(mem_info);
    }

    // 비밀번호 찾기 - 이메일 코드 인증
    @PostMapping("/android/getCode")
    public String getCode(@RequestBody Member mem_info) throws Exception {
        return androidService.getCode(mem_info);
    }
    
    @PostMapping("/android/withdrawal")
    public int withdrawal(@RequestBody Member mem_info) {
    	return androidService.withdrawal(mem_info);
    }


    // group
    @PostMapping("/android/getGroup")
    public List<Group> getGroup(@RequestBody Member user_info) {
        return androidService.getGroup(user_info.getMem_id());
    }

    @PostMapping("/android/groupInfo")
    public Group groupInfo(@RequestBody Group group_info) {
        return androidService.groupInfo(group_info.getGroup_seq());
    }

    @PostMapping("/android/joinDate")
    public Group joinDate(@RequestBody Group group_info) {
        return androidService.joinDate(group_info);
    }

    @PostMapping("/android/userInfo")
    public Member userInfo(@RequestBody Member user_info) {
        return androidService.userInfo(user_info.getMem_id());
    }

    @PostMapping("/android/groupMem")
    public List<Group> groupMem(@RequestBody Group group_info) {
        return androidService.groupMem(group_info.getGroup_seq());
    }

    @PostMapping("/android/groupOut")
    public int groupOut(@RequestBody Group group_info) {
        return androidService.groupOut(group_info);
    }

    @PostMapping("/android/joinGroup")
    public int joinGroup(@RequestBody Group group_info) {
        return androidService.joinGroup(group_info);
    }


    // TodoList 할일체크
    @PostMapping("/android/getCategory")
    public List<Category> getCategory(@RequestBody Category category) {
        return androidService.getCategory(category);
    }

    @PostMapping("/android/getToDoList")
    public List<ToDo> getToDoList(@RequestBody ToDo todo) {
        return androidService.getToDoList(todo.getCate_seq());
    }

    @PostMapping("/android/getToDoComplete")
    public List<ToDoComplete> getToDoComplete(@RequestBody ToDoComplete cmpl_info) {
        return androidService.getToDoComplete(cmpl_info.getCate_seq());
    }

    @PostMapping("/android/getToDo")
    public ToDo getToDo(@RequestBody ToDo todo_info) {
        return androidService.getToDo(todo_info);
    }

    @PostMapping("/android/getToDoCmplList")
    public List<ToDoComplete> getToDoCmplList(@RequestParam int todo_seq) {
        return androidService.getToDoCmplList(todo_seq);
    }

    @PostMapping("/android/todoCmpl")
    public int todoCmpl(@RequestBody ToDoComplete cmpl_info) {
        return androidService.todoCmpl(cmpl_info);
    }
    
    @PostMapping("/android/getMemo")
    public List<ToDoComplete> getMemo(@RequestParam String cmpl_time, int group_seq){
    	return androidService.getMemo(cmpl_time, group_seq);
    }
    
    @PostMapping("/android/deleteTodoMemo")
    public int deleteTodoMemo(@RequestParam int cmpl_seq, String cmpl_memo) {
    	return androidService.deleteTodoMemo(cmpl_seq, cmpl_memo);
    }
    
    @PostMapping("/android/getCmpl")
    public ToDoComplete getCmpl(@RequestParam int cmpl_seq) {
    	return androidService.getCmpl(cmpl_seq);
    }
    
    @PostMapping("/android/todoModify")
    public int todoModify(@RequestBody ToDoComplete cmpl_info) {
    	return androidService.todoModify(cmpl_info);
    }


    // Notice 전달사항
    @PostMapping("/android/getNotice")
    public List<Notice> getNotice(@RequestBody Notice notice) {
        return androidService.getNotice(notice);
    }

    @PostMapping("/android/getNoticeDetail")
    public Notice getNoticeDetail(@RequestBody Notice notice) {
        return androidService.getNoticeDetail(notice);
    }

    @PostMapping("/android/categoryDelete")
    public int categoryDelete(@RequestBody Category category_info) {
        return androidService.categoryDelete(category_info);
    }

    @PostMapping("/android/noticeDelete")
    public int noticeDelete(@RequestBody Notice notice_info) {
        return androidService.noticeDelete(notice_info);
    }

    @PostMapping("/android/noticeWrite")
    public int noticeWrite(@RequestBody Notice notice_info) {
        System.out.println(notice_info);
        return androidService.noticeWrite(notice_info);
    }

    @PostMapping("/android/writeComment")
    public int writeComment(@RequestBody NoticeComment com_info) {
        return androidService.writeComment(com_info);
    }

    @PostMapping("/android/getComment")
    public List<NoticeComment> getComment(@RequestBody NoticeComment com_info) {
        return androidService.getComment(com_info);
    }

    @PostMapping("/android/deleteComment")
    public int deleteComment(@RequestBody NoticeComment com_info) {
        return androidService.deleteComment(com_info.getCom_seq());
    }


    // Attendance 근무일정
    @PostMapping("/android/getAttendance")
    public List<Attendance> getAttendance(@RequestBody Attendance att_info) {
        return androidService.getAttendance(att_info);
    }

    @PostMapping("/android/getAtt")
    public Attendance getAtt(@RequestBody Attendance att_info) {
        return androidService.getAtt(att_info.getAtt_seq());
    }

    @PostMapping("/android/attCh")
    public int attCh(@RequestBody ChangeAttendance att_info) {
        return androidService.attCh(att_info);
    }

    @PostMapping("/android/checkAttCh")
    public ChangeAttendance checkAttCh(@RequestBody ChangeAttendance att_info) {
        return androidService.checkAttCh(att_info.getAtt_seq());
    }

    @PostMapping("/android/getAttTime")
    public double getAttTime(@RequestParam String mem_id, int group_seq, String start_date, String end_date){
        return androidService.getAttTime(mem_id, group_seq, start_date, end_date);
    }
}
