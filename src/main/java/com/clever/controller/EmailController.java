package com.clever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.CheckEmail;
import com.clever.service.EmailService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmailController {
	
	Gson gson = new Gson();
	
	@Autowired
	private EmailService emailService;
	
	@ResponseBody
	@RequestMapping(value = "/mailcheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String emailCheck(@RequestBody String email) throws Exception {
		    	
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("요청 : " + email);
		
		CheckEmail userEmail = gson.fromJson(email, CheckEmail.class);
		
		String code = emailService.sendSimpleMessage(userEmail.getCheckEmail());

		System.out.println("인증코드 : " + code);
				
		return code;
	}

}
