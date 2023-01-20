package com.clever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Category;
import com.clever.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/addcategory")
	public int addBoardCategory(@RequestBody Category cate_info) {
		System.out.println(cate_info);
		return boardService.addBoardCategory(cate_info);
	}
	
	@PostMapping("/countcategory")
	public int countBoardCategory(@RequestBody Category cate_info) {
		System.out.println(cate_info);
		return boardService.countBoardCategory(cate_info);
	}
	
	public void getBoardCategory(@RequestBody Category cate_info) {
		System.out.println(cate_info);
	}

}
