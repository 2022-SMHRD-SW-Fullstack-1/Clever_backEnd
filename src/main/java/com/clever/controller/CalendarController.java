package com.clever.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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


	

	@GetMapping("/getSchedule")
	public List<CalendarInput> getSchedule()throws Exception {					
		return calendarService.getSchedule();
	}
	
	
	
	@RequestMapping(value = "/saveArrScheduleInfo", method = RequestMethod.POST)	
	public void insertSchedule(@RequestBody ArrayList<CalendarInput> saveArrScheduleInfo)throws Exception{	
		System.out.println("컨트롤러"+saveArrScheduleInfo);
		

		calendarService.insertSchedule(saveArrScheduleInfo);
		
	}

}
