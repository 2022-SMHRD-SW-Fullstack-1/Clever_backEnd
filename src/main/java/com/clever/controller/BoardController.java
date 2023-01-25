package com.clever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		return boardService.addBoardCategory(cate_info);
	}
	
	@PostMapping("/countcategory")
	public int countBoardCategory(@RequestBody Category cate_info) {
		return boardService.countBoardCategory(cate_info);
	}
	
	@PostMapping("/getcategory")
	public List<Category> getBoardCategory(@RequestBody Category cate_info) {	
		List<Category> cateList = boardService.getBoardCategory(cate_info.getGroup_seq());
		return cateList;
	}
	
	@PostMapping("/post")
	public int postBoard(@RequestPart(value="inputValue", required=false) Notice notice_info,
						 @RequestParam(value="inputFile", required=false) MultipartFile[] upload_file) throws Exception{

		return boardService.postBoard(notice_info, upload_file);
	}
	
	@PostMapping("/list")
	public List<Notice> getBoardList(@RequestBody Notice notice_info){
		List<Notice> boardList = boardService.getBoardList(notice_info.getCate_seq());
		return boardList;
	}	
}
