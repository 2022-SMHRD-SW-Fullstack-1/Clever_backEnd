package com.clever.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clever.mapper.CalendarMapper;
import com.clever.model.CalendarInput;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarMapper calendarMapper;
	

	public void insertSchedule(ArrayList<CalendarInput> saveArrScheduleInfo) {		

		for(int i=0; i<saveArrScheduleInfo.size(); i++) {		
			
			calendarMapper.insertSchedule(saveArrScheduleInfo.get(i));			
		}       						
	}
	
	public List<CalendarInput> getSchedule() {
		
		return calendarMapper.getSchedule();
	}
	

}
