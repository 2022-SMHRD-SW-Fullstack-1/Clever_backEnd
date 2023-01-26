package com.clever.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.CalendarMapper;
import com.clever.model.Attendance;
import com.clever.model.ChangeAttendance;
import com.clever.model.Join;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarMapper calendarMapper;
	


	public List<Attendance> getSchedule(int groupSeq) {
		
		return calendarMapper.getSchedule(groupSeq);
	}
	
	
	
	public void insertSchedule(ArrayList<Attendance> saveArrScheduleInfo) {	
	

		System.out.println("받은 인풋"+saveArrScheduleInfo.get(0));
		for(int i=0; i<saveArrScheduleInfo.size(); i++) {		
			
			calendarMapper.insertSchedule(saveArrScheduleInfo.get(i));			
		}       						
	}
	
	public void updateSchedul(ArrayList<Attendance> updateInfo) {
//		int totalResult = 0;
//		int sent =updateInfo.size();
//		int result = 0;
//		System.out.println("받은업데이트 정보 :"+ updateInfo.get(0));		
		
		System.out.println("받은 정보 : "+updateInfo);
		
		calendarMapper.deleteSchedul(updateInfo.get(0));
		if(updateInfo.size() != 0) {
			for(int i=0; i<updateInfo.size(); i++) {							
				System.out.println("수정할 정보 : " + updateInfo.get(i));
				calendarMapper.updateSchedul(updateInfo.get(i));		
//				System.out.println(i+1+"번째 결과"+result);
//				totalResult += result ;
			}	
		}
//		if(updateInfo.size()==0) {
//			System.out.println("삭제완료");	
//		}else {
//			for(int i=0; i<updateInfo.size(); i++) {							
//				System.out.println("수정할 정보 : " + updateInfo.get(i));
////				result =  calendarMapper.updateSchedul(updateInfo.get(i));		
////				System.out.println(i+1+"번째 결과"+result);
////				totalResult += result ;
//			}
//		}
	
//		System.out.println("요청수 :"+sent +"성공한 수:"+totalResult);
	
		
	
	
		
				
				
	}
	public int deleteSchedul(ArrayList<Attendance> date) {
		
		
		return calendarMapper.deleteSchedul(date.get(0));
	}
	
	public List<ChangeAttendance> getModification(int groupSeq){
		
		return calendarMapper.getModification(groupSeq);
	}
	
	
	public int confirmModification(List<ChangeAttendance> confirmInfo) {
		 
		int resultUpdate = calendarMapper.confirmModification(confirmInfo.get(0));
		int resultUpdate1 = calendarMapper.updateModifiCation(confirmInfo.get(0));
		
		System.out.println("업데이트 :"+resultUpdate);
		System.out.println("진짜 업데이트 :"+resultUpdate1);
		
		return 0 ;
	}
   
	public int rejectModification(List<ChangeAttendance> rejectInfo) {
		System.out.println("받은것 :"+ rejectInfo);
		calendarMapper.rejectModification(rejectInfo.get(0));
		
	
		
		return 0;
	}
	
	public List<Join> getWorkerList(int groupSeq){
		return calendarMapper.getWorkerList(groupSeq);
	}
	

}