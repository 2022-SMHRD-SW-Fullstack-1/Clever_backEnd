package com.clever.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.CalendarInput;
import com.clever.service.CalendarService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	//  public int addSchedule	(@RequestParam(value="saveArrScheduleInfo") List<CalendarInput> saveArrScheduleInfo) throws Exception
	

	
	
	@RequestMapping(value = "/saveArrScheduleInfo", method = RequestMethod.POST)
	public String saveArrScheduleInfo(@RequestBody HashMap<String,Object> saveArrScheduleInfo)throws Exception{	
		
		
		
		System.out.println("받은것 :"+ saveArrScheduleInfo);
		System.out.println(saveArrScheduleInfo.get("saveArrScheduleInfo"));
		System.out.println(saveArrScheduleInfo.get("saveArrScheduleInfo"));
		ArrayList<Object> o = (ArrayList<Object>) saveArrScheduleInfo.get("saveArrScheduleInfo"); 
		System.out.println(o.get(0));
//		calendarService.addShcedule(saveArrScheduleInfo);
		
		
		return "";
	}

}
