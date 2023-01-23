package com.clever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clever.model.Category;
import com.clever.model.Notice;
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
	
	@PostMapping("/getcategory")
	public List<Category> getBoardCategory(@RequestBody Category cate_info) {
		System.out.println(cate_info);
		List<Category> cateList = boardService.getBoardCategory(cate_info.getGroup_seq());
		return cateList;
	}
	@PostMapping("/post")
	public int postBoard(@RequestBody Notice notice_info) {
		System.out.println(notice_info);
		return boardService.postBoard(notice_info);
	}
	
	@PostMapping("/list")
	public List<Notice> getBoardList(@RequestBody Notice notice_info){
		System.out.println(notice_info);
		List<Notice> boardList = boardService.getBoardList(notice_info.getCate_seq());
		return boardList;
	}

}
