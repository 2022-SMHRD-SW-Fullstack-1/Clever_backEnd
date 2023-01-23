package com.clever.service;

import java.util.List;

import com.clever.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.controller.EmailController;
import com.clever.mapper.AndroidMapper;

@Service
public class AndroidService {

    @Autowired
    AndroidMapper androidMapper;

    @Autowired
    EmailService emailService;

    // member
    public int joinMember(Member join_info) {
        return androidMapper.joinMember(join_info);
    }

    public Member login(Member login_info) {
        return androidMapper.login(login_info);
    }

    public int chName(Member mem_info) {
        return androidMapper.chName(mem_info);
    }

    public int changePw(Member mem_info) {
        return androidMapper.changePw(mem_info);
    }

    // 비밀번호 찾기 - 이메일 코드 인증
    public String getCode(Member mem_info) throws Exception {
        Member result = androidMapper.getCode(mem_info);

        if (result != null) {

            String code = emailService.sendSimpleMessage(result.getMem_email());
            System.out.println("코드 : " + code);

            return code;
        } else {
            return "1";
        }
    }


    // group
    public List<Group> getGroup(String mem_id) {
        return androidMapper.getGroup(mem_id);
    }

    public Group groupInfo(int group_seq) {
        return androidMapper.groupInfo(group_seq);
    }

    public Group joinDate(Group group_info) {
        return androidMapper.joinDate(group_info);
    }

    public Member userInfo(String mem_id) {
        return androidMapper.userInfo(mem_id);
    }

    public List<Group> groupMem(int group_seq) {
        return androidMapper.groupMem(group_seq);
    }

    public int groupOut(Group group_info) {
        int result = androidMapper.groupDelete(group_info);

        if (result == 1) {
            return result;
        } else {
            return androidMapper.groupOut(group_info);
        }
    }

    public int joinGroup(Group group_info) {
        Group result = androidMapper.groupSerialCheck(group_info.getGroup_serial());
        if (result != null) {
            System.out.println(result.getGroup_seq());
            System.out.println(group_info.getMem_id());
            return androidMapper.joinGroup(result.getGroup_seq(), group_info.getMem_id());
        } else {
            return 0;
        }
    }


    // TodoList 할일체크
    public List<Category> getCategory(Category category) {
        return androidMapper.getCategory(category);
    }

    public List<ToDo> getToDoList(int cate_seq) {
        return androidMapper.getToDoList(cate_seq);
    }

    public List<ToDoComplete> getToDoComplete(int cate_seq) {

        List<ToDoComplete> getTodo = androidMapper.getToDoComplete(cate_seq);

        for (int i = 0; i < getTodo.size(); i++) {
            int todo_seq = getTodo.get(i).getTodo_seq();
            String title = androidMapper.getTodoTitle(todo_seq);
            getTodo.get(i).setTodo_title(title);
        }
        return getTodo;
    }

    public ToDo getToDo(ToDo todo_info) {

        ToDo result = androidMapper.getToDo(todo_info);
        if (result.getMem_id() != null) {
            Member memId = androidMapper.userInfo(result.getMem_id());
            result.setMem_name(memId.getMem_name());
            return result;
        } else {
            return androidMapper.getToDo(todo_info);
        }
    }

    public List<ToDoComplete> getToDoCmplList(int todo_seq) {
        return androidMapper.getToDoCmplList(todo_seq);
    }

    public int todoCmpl(ToDoComplete cmpl_info) {
        return androidMapper.todoCmpl(cmpl_info);
    }



    // Notice 전달사항
    public List<Notice> getNotice(Notice notice) {
        return androidMapper.getNotice(notice);
    }

    public Notice getNoticeDetail(Notice notice) {
        return androidMapper.getNoticeDetail(notice);
    }

    public int categoryDelete(Category category_info) {
        return androidMapper.categoryDelete(category_info);
    }

    public int noticeDelete(Notice notice_info) {
        return androidMapper.noticeDelete(notice_info);
    }

    public int noticeWrite(Notice notice_info) {
        return androidMapper.noticeWrite(notice_info);
    }

    public int writeComment(NoticeComment com_info){
        return androidMapper.writeComment(com_info);
    }

    public List<NoticeComment> getComment(NoticeComment com_info){
        return androidMapper.getComment(com_info);
    }

    public int deleteComment(int com_seq){
        return androidMapper.deleteComment(com_seq);
    }



    // Attendance 근무일정
    public List<Attendance> getAttendance(Attendance att_info) {
        return androidMapper.getAttendance(att_info);
    }

    public Attendance getAtt(int att_seq) {
        return androidMapper.getAtt(att_seq);
    }

    public int attCh(ChangeAttendance att_info) {
        return androidMapper.attCh(att_info);
    }


}
