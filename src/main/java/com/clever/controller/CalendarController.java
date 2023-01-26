package com.clever.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Attendance;
import com.clever.model.ChangeAttendance;
import com.clever.model.Join;
import com.clever.service.CalendarService;

@CrossOrigin(origins = "*")
@RestController
public class CalendarController {

	@Autowired
	private CalendarService calendarService;


	

	@GetMapping("/getSchedule/{groupSeq}")
	public List<Attendance> getSchedule(@PathVariable int groupSeq)throws Exception {					
		return calendarService.getSchedule(groupSeq);
	}

	
	
	
	@RequestMapping(value = "/saveArrScheduleInfo", method = RequestMethod.POST)	
	public void insertSchedule(@RequestBody ArrayList<Attendance> saveArrScheduleInfo)throws Exception{			

		System.out.println("받은것 :"+ saveArrScheduleInfo);
		calendarService.insertSchedule(saveArrScheduleInfo);
		
	}	
	@RequestMapping(value = "/updateSchedul", method = RequestMethod.POST)
	public void updateSchedul(@RequestBody ArrayList<Attendance> updateInfo)throws Exception{
		
		 calendarService.updateSchedul(updateInfo);
		
	}
	
	@PostMapping("/deleteSchedul/{date}")
	public int deleteSchedul(@PathVariable String date) {	
		
		int result =calendarService.deleteSchedul(date);
	
		return result;
	}
	
	@GetMapping("/getModification/{groupSeq}")
	public List<ChangeAttendance> getModification(@PathVariable int groupSeq){
		
		return calendarService.getModification(groupSeq);
	}
	
	@PostMapping("/confirmModification")
	public int confirmModification(@RequestBody ArrayList<ChangeAttendance> confirmInfo){
		
		return calendarService.confirmModification(confirmInfo);				
	}

	@PostMapping("/rejectModification")
	public int rejectModification(@RequestBody ArrayList<ChangeAttendance> rejectfirmInfo){
		
		return calendarService.rejectModification(rejectfirmInfo);				
	}
	@GetMapping("/getWorkerList/{groupSeq}")
	public List<Join> getWorkerList(@PathVariable int groupSeq){
	
		return calendarService.getWorkerList(groupSeq);
		
	}
	
	
	

}