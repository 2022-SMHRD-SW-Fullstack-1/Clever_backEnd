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
		int totalResult = 0;
		int sent =updateInfo.size();
		int result = 0;
		
	
		if(updateInfo.size()==1) {
			System.out.println("받은업데이트 정보 :"+ updateInfo.get(0));
			calendarMapper.updateSchedul(updateInfo.get(0));
		}else {
			for(int i=0; i<updateInfo.size(); i++) {
				
				System.out.println(i+1+"번째 data :"+updateInfo.get(0));
				result =  calendarMapper.updateSchedul(updateInfo.get(i));		
				System.out.println(i+1+"번째 결과"+result);
				totalResult += result ;
			}
		}
	
		System.out.println("요청수 :"+sent +"성공한 수:"+totalResult);
	
		
	
	
		
				
				
	}
	public int deleteSchedul(String date) {
		
		return calendarMapper.deleteSchedul(date);
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