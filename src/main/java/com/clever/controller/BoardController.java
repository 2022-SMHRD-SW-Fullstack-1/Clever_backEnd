package com.clever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Category;
import com.clever.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	public void getBoardCategory(@RequestBody Category cate_info) {
		System.out.println(cate_info);
	}

}
