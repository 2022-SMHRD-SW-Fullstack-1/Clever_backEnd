package com.clever.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.CalendarMapper;
import com.clever.model.CalendarInput;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarMapper calendarMapper;
	

	public int addShcedule(ArrayList<CalendarInput> saveArrScheduleInfo) {
		

		System.out.println("길이"+saveArrScheduleInfo.size());
		System.out.println("타입"+saveArrScheduleInfo.get(0).getClass().getName());

		for(int i=0; i<saveArrScheduleInfo.size(); i++) {
		
			
			calendarMapper.addSchedule(saveArrScheduleInfo.get(i));
			
		}
//		calendarService.addShcedule(saveArrScheduleInfo);
		
		
       
      
      
		
		
		return 0;
		
	}
	

}
