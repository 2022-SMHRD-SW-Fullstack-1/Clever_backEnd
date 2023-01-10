package com.clever.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AndroidController {

	@GetMapping("/android/hello")
	public String hello() {

		System.out.println("Hello Android");

		return "Hello Android";
	}

}
