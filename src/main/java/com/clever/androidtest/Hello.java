package com.clever.androidtest;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping("/hello/android")
	public String join() {
		
		System.out.println("Hello Android");

		return "Hello Android";
	}
	
	
}
